package com.ohgiraffers.injection.chap01.section01;

import com.ohgiraffers.injection.chap01.section01.config.AppConfig;
import com.ohgiraffers.injection.chap01.section01.service.PaymentInterface;
import com.ohgiraffers.injection.chap01.section01.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application { //Application.java -> Application.class
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentService paymentService = context.getBean(PaymentService.class);
        paymentService.processPayment("335433", 39584);

        ((AnnotationConfigApplicationContext)context).close();
    }
}
