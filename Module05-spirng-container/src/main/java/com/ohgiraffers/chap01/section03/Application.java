package com.ohgiraffers.chap01.section03;

import com.ohgiraffers.chap01.section03.service.PaymentsService;
import com.ohgiraffers.chap01.section03.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("=== 싱글톤 스코프 테스트 ===");
        /**
         * 싱글톤 스코프에서 singlePay 빈이 단일 인스턴스로 생성된다.
         * 따라서 singlePay와 singlePay2는 동일한 객체를 참조하며,
         * processPayment() 호출로 상태가 변경되면 모든 참조에서 공유된다.
         *
         * - 상태를 가지지 않는 서비스 로직: 예를 들어, 결제 로직 자체는 상태를 저장하지 않고 외부 db나 캐시에 의존한다.
         * - 공통 설정 객체: 애플리케이션 전반에서 동일한 설정(예: api 키, 환경변수)를 공유해야할 때.
         * - 메모리 효율성을 극대화해야할 때: 단일 인스턴스로 모든 요청을 처리해 자원 낭비를 줄임
         * **상태를 가지는 것들은 bean으로 등록안함.
         */

        PaymentsService singPay = context.getBean("singlePay", PaymentsService.class);
        singPay.processPayment("gdsfd", 190);
        System.out.println("싱글 페이의 마지막 주문ID: " + singPay.getLastOrderId());

        PaymentsService singPay2 = context.getBean("singlePay", PaymentsService.class);
        System.out.println("싱글 페이2의 마지막 주문ID: " + singPay.getLastOrderId());

        System.out.println(singPay == singPay2);
        System.out.println();

        System.out.println(" === 프로토타입 스코프 테스트 ===");
        //상태가 같지 않다.
        /**
         * 프로토타입 스코프에서는 protoPay빈이 요청 시마다 새 인스턴스로 생성된다.
         * protoPay와 protoPay2는 서로 다른 객체이므로, 상태가 독립적으로 유지된다.
         *
         * - 상태를 가지는 (statefull)객체: 예를 들어 사용자별 결제 세션, 주문별 임시 데이터 저장
         * - 요청별 독립적인 처리 : 각 http 요청마다 별도의 결제 상태를 유지해야할 때 (웹 애플리케이션에서 유용)
         * - 테스트 환경: 단위 테스트에서 독립적인 객체를 생성해 테스트 케이스 간 간섭을 방지.
         */
        PaymentsService protoPay = context.getBean("protoPay", PaymentsService.class); //빈이 다르다.
        protoPay.processPayment("gdsfd", 190);
        System.out.println("프로토 페이의 마지막 주문ID: " + protoPay.getLastOrderId());

        PaymentsService protoPay2 = context.getBean("protoPay", PaymentsService.class);//빈이 다르다.
        System.out.println("프로토 페이2의 마지막 주문ID: " + protoPay2.getLastOrderId());

        System.out.println(protoPay == protoPay2);
        System.out.println();
    }
}
