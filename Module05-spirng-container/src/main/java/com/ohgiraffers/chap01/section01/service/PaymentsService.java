package com.ohgiraffers.chap01.section01.service;

public class PaymentsService {

    private NaverPayGateway paymentGateway;

    public PaymentsService(NaverPayGateway naverPayGateway) {
        this.paymentGateway = naverPayGateway;
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 처리를 시작합니다. 주문 id : " + orderId + ", 금액 : " + amount);
        boolean paymentResult = paymentGateway.processPayments(orderId, amount);

        if (paymentResult) {
            System.out.println("결제가 성공적으로 처리되었습니다.");
        } else {
            System.out.println("결제 처리 중 오류가 발생하였습니다.");
        }

        return paymentResult;
    }
}
