package com.ohgiraffers.injection.chap01.section02.service;

import com.ohgiraffers.injection.chap01.section01.service.PaymentInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class NaverPayGateway implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("NaverPayGateway.processPayment" + orderId + " " + amount);
        return true;
    }

}
