package com.ohgiraffers.chap01.section04.service;

public class KaKaoPayGateway implements PaymentsInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오 페이 결제 시작: 주문 번호 = " + orderId + ", 주문 금액 = " + amount);

        return true;
    }
}
