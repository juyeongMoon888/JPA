package com.ohgiraffers.injection.chap01.section02.service;

import org.springframework.stereotype.Service;

/**
 * @Service
 * - @Compoent의 특수화된 형태로, 서비스 계층에 속하는 빈을 나타낸다
 * 역할 : 비즈니스 로직을 처리하는 클래스에 사용하며 스프링이 이름을 빈으로 등록.
 * 빈 이름 : paymentsService
 * 예시 : 비즈니스의 핵심 로직을 담당.
 * 컴포넌트 스캔으로 자동으로 등록되며, 생명주기(생성->사용->소멸)관리됨
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

        if(result)
            System.out.println("결제 성공");
        else
            System.out.println("결제 실패");

        return result;
    }
}

