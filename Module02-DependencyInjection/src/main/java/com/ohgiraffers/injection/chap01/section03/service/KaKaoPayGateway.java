package com.ohgiraffers.injection.chap01.section03.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 카카오페이 결제 게이트웨이 구현체
 * @Component
 * -Spring이 이 클래스를 컴ㅍ모넌트로 인식하여 bean으로 등록하도록 지시.
 * - 역할: 일반적인 bean을 정의하며, spring 컨테이너가 관리할 객체임을 나차낸다.
 * - bean 이름: 기본값 클래스명 첫 글자 소문자
 * -예시: 독립적인 기능 모듈(예 결제 게이트웨이, 유틸클래스)에 사용
 */
@Component("kakaoPay03")
@Primary
public class KaKaoPayGateway implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오 페이로 결제를 진행합니다." + orderId + "금액: "  + amount);
        return true;
    }
}
