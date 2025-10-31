package com.ohgiraffers.injection.chap01.section01.service;

public interface PaymentInterface {

    boolean processPayment(String orderId, double amount);
}
