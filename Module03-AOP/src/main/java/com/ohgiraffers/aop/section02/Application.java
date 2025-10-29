package com.ohgiraffers.aop.section02;

import com.ohgiraffers.aop.section02.MemberService;
import com.ohgiraffers.aop.section02.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);

        try {
            System.out.println("테스트 1 회원 가입");
            Member member = new Member("user@example.com", "pass123", "홍길동", "010-3433-2333", "학생");
            memberService.registerMember(member);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
