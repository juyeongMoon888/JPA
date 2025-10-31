package com.ohgiraffers.injection.chap01.section02.service;

public interface PaymentInterface {

    boolean processPayment(String orderId, double amount);
}
