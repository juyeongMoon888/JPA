package com.ohgiraffers.jpql.chap01.section05.dto;

public class CourseDTO {
    private int courseId;
    private String title;
    private Long lessonCount;

    public CourseDTO(int courseId, String title, Long lessonCount) {
        this.courseId = courseId;
        this.title = title;
        this.lessonCount = lessonCount;
    }


}
