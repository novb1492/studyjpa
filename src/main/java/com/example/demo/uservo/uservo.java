package com.example.demo.uservo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Table(name="members")
public class uservo {
 
    @Column(name="id")
    private String id;

    public String getid()
    {
        return this.id;

    }
}
