package com.ohgiraffers.jpql.chap01.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private int lessonId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected Lesson() {}

    public Lesson(Course course, String title, String content, LocalDateTime createdAt) {
        this.course = course;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public int getLessonId() {
        return lessonId;
    }

    public Course getCourse() {
        return course;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
