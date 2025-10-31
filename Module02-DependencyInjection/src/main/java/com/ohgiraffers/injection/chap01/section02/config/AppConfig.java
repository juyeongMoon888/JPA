package com.ohgiraffers.injection.chap01.section02.config;

import com.ohgiraffers.injection.chap01.section02.service.PaymentInterface;
import com.ohgiraffers.injection.chap01.section02.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring 컴포넌트 스캔 설정
 * - @ComponentScan
 *   - 지정된 패키지에서 @Component, @Service 등의 어노테이션이 붙은 클래스를 탐지하여 bean으로 등록한다.
 *   - basePackages:  "경로"를 설저앟여 현재 패키지와 하위 패키지 모두 스캔
 * - 동작과정
 * 1. 컨테이너 시작 시 지정된 패키지를 탐색
 * 2. @Component, @Service 등이 붙은 클래스를 인식
 * 3. 해당 클래스들을 bean으로 등록하고 의존성 주입 수행.
 *
 * - 이점
 * 1. 코드 간소화: @Bean으로 일일이 정의하 ㄹ필요없음
 * 2. 유연성" 새로운 컴포넌트 추가 시 설정 변경 없이 자동으로 인식/
 *
 */
@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.injection.chap01.section02")
public class AppConfig {
    /**
     * 컴포넌트 스캔을 활용하면 발생하는 이점.
     * 1. 코드 간소화 및 생ㅅ낫엉 향상
     *      @Bean으로 개별 클래스를 수동 정의할 필요없이 @Component, @Service등의 어노태이션으로 자동 등록,
     *      2. 유연한 확장성
     *      - 새로운 컴포넌트를  추가할 때 appConfig를 수정하지 않고, 해당 패키지에 클래스만 추가하면 자동 인식.
     *
     *      3. 의존성 주입 자동화
     *      - @Autowired와 함께 사용하면 컴포넌트 간 의존성을 spring이 자동으로 연결
     *      4. 일관된 Bean 관리
     *      - 스캔 시 beanㅇ은 spring ioc컨테이너에 의해 관리.
     *      5.개발 표준화
     *      - @Compotnentl @ervoce 등ㅇ로 계층별 역할 명시 가능
     *
     *      주의사항
     *      - 스캔 범위가 너무 넓으면 불필요한 클래스까지 Bean으로 등록될 수 있음 -> 성능 저하
     *      = 동일 타입의 bean이 여러 개일 경우 충돌 발생 -> @Quarlifier, @Primary로 해결

     */

    @Bean("kakaoPaymentService")
    public PaymentService kakaoPayService(PaymentInterface paymentGateway) {
        return new PaymentService(paymentGateway);
    }

    @Bean("naverPayService")
    public PaymentService naverPayService(PaymentInterface paymentGateway) {
        return new PaymentService(paymentGateway);
    }
}
