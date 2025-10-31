package com.ohgiraffers.injection.chap01.section02;

import com.ohgiraffers.injection.chap01.section02.config.AppConfig;
import com.ohgiraffers.injection.chap01.section02.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 의존성 주입
 * - Spring 프레임워크에서 객체 간 의존성을 개발자가 직접 관리하지 ㅇ낳고, IOC 컨테이너가 자동으로 주입하는 매커니즘
 *.
 * - 이점: 결합도 감소
 * - 테스트용이성
 * - 유지보수성 향상
 * - 주의 동일한 타입의 Bean 충돌 가능성
 * - 해결 방법
 *      -@Qualifier: 특정 bean의 이름을 지정
 *      -@Primary: 기본으로 사용할 bean 지정
 *      -단일 구현체 사용: 불필요한 구현체의 @Component 제거
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentService naverPayService = context.getBean("naverPayService", PaymentService.class);
        naverPayService.processPayment("335433", 39584);

        PaymentService kakaoPayService = context.getBean("kakaoPayService", PaymentService.class);
        kakaoPayService.processPayment("335433", 39584);

        ((AnnotationConfigApplicationContext)context).close();
    }

}
