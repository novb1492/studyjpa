package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getter setter대신
@NoArgsConstructor//bean생성자
@AllArgsConstructor//전체생정자
@Builder//빌더패턴 나중에 알게된다
@Entity///user클래스가 mysql에 자동으로 테이블을 만든다
public class boards {
    
    @Id//primary key라고 알려준다
    @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에 연결된 db의 넘버링 전략 따라감 ex auto_increment처럼
    private int bid;
    
    @Column(nullable = false,length = 100)//not null,글자수 제한
    private String btitle;
    
    @Lob//대용량 데이터
    private String bcontent;
    
    @ColumnDefault("0")/////기본 설정 
    private int count;

    @ManyToOne//1:n 한면의 사람이 여러개의 글을 쓸수있다
    @JoinColumn(name="uid")
    private user user;

    @OneToMany(mappedBy = "boards" ,fetch=FetchType.EAGER)//하나의 개시글에는 여러개의 댓글 제 1정규형 위반 때매 컬럼 생성x
    private List<reply>reply;///여기서 바로 array list쓰면 빌드 실패함

    @CreationTimestamp///시간이 자동으로 들어감
    private Timestamp bcreated;

}
