package com.ohgiraffers.injection.chap01.section01.service;

import org.springframework.stereotype.Service;

/**
 * @Service
 *  - @Conmpotnet의 특수화ㄴ된 형태로, 서비스 계층에 속하ㄴ는 beam을 나타낸다.
 *  역할: 브즈니스 로직을 처리하는 클래스에 사용되며, spring이 이름을 Bean으로 등록
 *  - Bean 이름: paymentService
 *  -예시: 비즈니스의 핵심 로직을 담당
 *  = 컴포넌트 스켄으로 자동 등록 되며, 새영주기 (생선->사용->소m멸) 관리됮
 */
@Service
public class PaymentService {

    private final PaymentInterface paymentInterface;

    public PaymentService(PaymentInterface paymentInterface) {
        this.paymentInterface = paymentInterface;
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 시작");
        boolean result = paymentInterface.processPayment(orderId, amount);
        if (result) {
            System.out.println("결제 성공");
        } else {
            System.out.println("결제 실패");
        }
        return result;
    }
}

