package com.ohgiraffers.chap01.mission.a_basic;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }
}
