package com.ohgiraffers.injection.chap01.section03.strategy.constructor;

import com.ohgiraffers.injection.chap01.section03.service.PaymentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 생성자 주입
 * @Autowired를 생성자에 적용하여 의존성 주입
 * - 장점:
 * 1. 불변성 보장: final 키워드로 의존성 변경 방지
 * 2. 필수 의존성 강제: 주입이 없으면 객체 생성 불가, 컴파일 시점에 오류 확인
 * 3. 테스트 용이성: 의존성을 명시적으로 전달 가능(mock 객체 주입 쉬움)
 * 4. 의존성 명확성: 코드만 봐도 필요한 의존성이 들어남
 *
 * - 단점
 * 1. 의존성이 많은 경우 생성자가 길어짐.
 *
 */
@Service
public class PaymentServiceConstructor {

    private final PaymentInterface paymentGateway; //final을 붙일 수 있어서 강제성, 불변식 가능하므로 추천

    //생성자 주입 동시에 생성하니까 null을 갖지 않음(불변식 보장)
    @Autowired
    public PaymentServiceConstructor(PaymentInterface paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 시작");
        boolean result = paymentGateway.processPayment(orderId, amount);
        if (result) {
            System.out.println("결제 성공");
        } else {
            System.out.println("결제 실패");
        }
        return result;
    }
}

