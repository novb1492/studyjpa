package com.example.demo.controller;

import com.example.demo.uservo.uservo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {
    
    @GetMapping("hello")
    public String name(Model model) {
        uservo vo=new uservo();
        String id=vo.getid();
    model.addAttribute("data", id);
      return "hello";///파일 찾아라
  }
}
