package com.ohgiraffers.chap01.section02;

import com.ohgiraffers.chap01.section02.service.PaymentsService;
import com.ohgiraffers.chap01.section02.config.AppConfig;
import com.ohgiraffers.chap01.section02.service.PaymentsInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * IOC (Inversion of Control, 제어의 역전)
 * 객체의 생성, 생명주기 관리까지 모든 객체에 대한 제어권이 바뀌었다는 것을 의미한다.
 * 즉, 개발자가 직접 객체를 생성하고 관리하는 대신, 프레임워크나 컨테이너가 객체의 생성, 의존성 주입, 생명주기를 관리하는 방식으로 제어 흐름이 역전되는 것을 말한다.
 *
 * 예를 들어 전통적인 방식에서는 개발자가 "new"키워드로 객체를 직접 생성하지만,
 * IOC에서는 컨테이너가 필요한 시점에 객체를 생성하고 제공한다.
 *
 * 1. IOC 컨테이너
 * - 스프링에서 IOC를 담당하는 컨테이너를 의미한다.
 * - bean의 생성, 관리, 제거 등으이 전체 라이프사이클을 관리한다.
 * - 개발자가 직접 new 연산자로 객체를 생성하고 관리하는 것이 아닌 컨테이너가 대신 처리한다.
 *
 * 2. IOC의 장점
 * - 객체 간의 결합도를 낮출 수 있다.
 * - 유연한 코드 작성이 가능하다.
 * - 코드의 재사용성이 높아진다.
 * - 단위 테스트가 용이하다.
 *
 * 3. IOC의 구현방법
 * - DL(Dependency lookup): 컨테이너가 제공하는 API로 bean을 검색한다.
 * - DI(Dependency injection): 각 클래스 간의 의존 관계를 자동으로 연결한다.
 *      * 생성자 주입: 생성자를 통해 의존성을 주입한다.
 *      * 설정자 주입: setter 메소드를 통해 의존성을 주입한다.
 *      * 필드 주입: 필드에 직접 의존성을 주입한다.
 *
 * 4. bean의 scope
 * - 스프링 컨테이너가 관리하는 bean의 생성 방식과 생성된 인스턴스의 관리 범위를 의미한다.
 * - 싱글톤(singleton): 기본 스코프 스프링 컨테이너당 하나의 인스턴스만 생성한다.
 * - 프로토타입: 요청할 때마다 새로운 인스턴스를 생성한다.
 * - 웹 스코프: request, session, application 등이 있다.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PaymentsService paymentsService = context.getBean("paymentsService", PaymentsService.class);
        //클래스만 지정하면 안되는 이유: 카카오페이를 연결할건지, 네이버페이를 할건지 모호하기 때문이다. 인터페이스 적용 시 타입 명확성을 위함 메서드의 이름이 bean의 이름이다. bean의 타입이 유일하면 class만 넣음
       /* PaymentsInterface paymentService = context.getBean("kaKaoPayGateway", PaymentsInterface.class);*/


        boolean result = paymentsService.processPayment("dsd", 190);
        System.out.println("결제 결과 : " + (result ? "성공" : "실패"));

        System.out.println();

        PaymentsService paymentsService2 = context.getBean("paymentsService", PaymentsService.class); //나를 그대로 반환 // 동시성을 주의해야한다. //싱글톤 기반
        System.out.println("paymentsService == paymentsService2 " + (paymentsService == paymentsService2));
    }
}
