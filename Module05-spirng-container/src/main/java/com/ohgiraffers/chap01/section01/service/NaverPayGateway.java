package com.ohgiraffers.chap01.section01.service;

public class NaverPayGateway {
    public boolean processPayments(String orderId, double amount) {
        System.out.println("네이버 페이로 결제를 진행합니다. 주문 Id = " + orderId + ", 금액 = " + amount);
        return true;
    }
}
