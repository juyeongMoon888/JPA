package com.ohgiraffers.injection.chap01.section03;

import com.ohgiraffers.injection.chap01.section03.service.KaKaoPayGateway;
import com.ohgiraffers.injection.chap01.section03.strategy.constructor.PaymentServiceConstructor;
import com.ohgiraffers.injection.chap01.section03.strategy.field.PaymentServiceField;

public class Application {
    public static void main(String[] args) {

        PaymentServiceConstructor paymentServiceConstructor = new PaymentServiceConstructor(new KaKaoPayGateway());
        paymentServiceConstructor.processPayment("1", 232);

        PaymentServiceField paymentServiceField = new PaymentServiceField();
        paymentServiceField.processPayment("1", 100);
    }
}
