package com.ohgiraffers.chap01.mission.a_basic;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    public Post(String title) {
        this.title = title;
    }
}
