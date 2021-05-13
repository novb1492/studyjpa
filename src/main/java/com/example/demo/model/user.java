package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity///user클래스가 mysql에 자동으로 테이블을 만든다
public class user {
    
    @Id//primary key라고 알려준다
    @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에 연결된 db의 넘버링 전략 따라감 ex auto_increment처럼
    private int id;
    
    @Column(nullable = false,length = 20)//not null,글자수 제한
    private String email;
    
    @Column(nullable = false,length = 100)//해쉬로 변경해야하기 때문에 100자리
    private String password;
    
    @ColumnDefault("'user'")/////기본 설정 
    private String role;////admin,user,manger 등권한부여 원래는 enum을 써야함 오타나면 큰일나서 

    @CreationTimestamp///시간이 자동으로 들어감
    private Timestamp created;


}
