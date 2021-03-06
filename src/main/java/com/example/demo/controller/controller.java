package com.example.demo.controller;

import java.util.function.Supplier;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import com.example.demo.model.roletype;
import com.example.demo.model.user;
import com.example.demo.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController//페이지를 넘어가는게 아니라 데이터만 주는 형식 
public class controller {
  
  @Autowired//의존성 주입 controller가 메모리에 뜰때 autowired가같이 띄어준다
  private userrepository userrepository;///클래스변수로 적어야함

  @PostMapping("delete")
  @DeleteMapping("delete")
    public String delete(@RequestParam("id")int id)
    {
      try {
        userrepository.deleteById(id);
      } catch (Exception e) {
        return "삭제실패";
      }

      return "삭제되어습니다";
    }
 
  @Transactional///더티 첵킹 이거 정보처리기능사 그거 영속성/일관성/격리성 같다
  @PostMapping("update")
  public String update(user users)
  {
    user user=userrepository.findById(5).orElseThrow(()->{
      return null;
    });//영속화시키는것
    
    user.setEmail(users.getEmail());
    user.setPassword(users.getPassword());
    //userrepository.save(user);///////update는 위에 조건을 걸어 준다 그러면 거길 알아서 찾아가서 바꾼다  혹은 이걸지우고 ->@transactional 더티책킹

    check(user.getEmail(), user.getPassword());
    return "정보수정완료";

  }

  @GetMapping("pagelist")
  public void pageList(@PageableDefault(size=2,sort = "id",direction = Sort.Direction.DESC)Pageable pageable)
  {
    /// find all 왜 오류나는거지
  }

  @GetMapping("selectall")
  public List<user>array()
  {
    return userrepository.findAll();///얘는 리턴타임 list<t>제네럴임 
  }

  @GetMapping("selectbyid")
  public user selectall()
  {
    user user=userrepository.findById(4).orElseThrow(new Supplier<IllegalArgumentException>(){
      public IllegalArgumentException get() {
        return new IllegalArgumentException("해당 유저는 없습니다 ");
      }
    });
     //1을 찾는데 못찾으면 null을 주면 문제생기닉까 optional로 너의 user객체를 감싸서 가져올테니 판탄해서 리턴해
     //스프링부트는 자바 객체 ->브라우저로 던져질시 자동으로 jackson라이브러리 호출해 json으로 변환해준다
    return user;
  }

  @PostMapping("join")
  public String join(user user,Model model)///이게된다고?? ㅋㅋㅋㅋ20210513
  //public String join(@RequestParam("email")String email,@RequestParam("password")String password,Model model)
  {
    user.setRole(roletype.user);///20210513우와 여기 enum은 이렇게 쓰인다

    userrepository.save(user);
      check(user.getEmail(),user.getPassword());
      return "회원가입완료";
  }
  private void check(String id,String pwd)
  {
    System.out.println(id+"joinemail");
    System.out.println(pwd+"joinemail");
  }
  
  
   /* @GetMapping("hello")
    public String name(Model model) {
        uservo vo=new uservo();
        String id=vo.getid();
    model.addAttribute("data", id);
      return "hello";///파일 찾아라
  }*/
}
