package com.ohgiraffers.injection.chap01.section03.service;

public interface PaymentInterface {

    boolean processPayment(String orderId, double amount);
}
