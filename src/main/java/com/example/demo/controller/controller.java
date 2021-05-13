package com.example.demo.controller;

import com.example.demo.model.user;
import com.example.demo.uservo.uservo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//페이지를 넘어가는게 아니라 데이터만 주는 형식
public class controller {
    
  @PostMapping("join")
  public String join(user user,Model model)///이게된다고?? ㅋㅋㅋㅋ20210513
  //public String join(@RequestParam("email")String email,@RequestParam("password")String password,Model model)
  {
    System.out.println(user.getEmail()+"joinemail");
    System.out.println(user.getPassword()+"joinemail");
      return "회원가입완료";
  }
  
   /* @GetMapping("hello")
    public String name(Model model) {
        uservo vo=new uservo();
        String id=vo.getid();
    model.addAttribute("data", id);
      return "hello";///파일 찾아라
  }*/
}
