package com.example.demo.repository;

import com.example.demo.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

//dao같은것들임
//bean자동등록 해줌 
public interface userrepository extends JpaRepository<user,Integer> {//제네릭 등장
    
}
