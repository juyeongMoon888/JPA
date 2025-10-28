package com.ohgiraffers.chap01.section03.service;

public class PaymentsService {

    private final PaymentsInterface paymentsInterface;
    private String lastOrderId;

    public String getLastOrderId() {
        return lastOrderId;
    }

    public PaymentsService(PaymentsInterface paymentsInterface) {
        this.paymentsInterface = paymentsInterface;
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 처리를 시작합니다. 주문 id : " + orderId + ", amount : " + amount);
        boolean paymentResult = paymentsInterface.processPayment(orderId, amount);
        this.lastOrderId = orderId;

        if (paymentResult) {
            System.out.println("결제가 성공적으로 처리되었습니다.");
        } else {
            System.out.println("결제가 실패하였습니다.");
        }
        return paymentResult;
    }
}
