package com.ohgiraffers.aop.section02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop를 활성화하는 스프링 설정 클래스
 * @EnableAspectJAutoProxy: Aspectj 스타일의 AOP를 스프링에서 활성화
 * - 스프링 AOP는 기본적으로 프록시 기반으로 동작하며, 이 어노테이션이 있어야 Aspect(@Aspect)가 적용된다.
 * - 프록시 생성을 통해 PointCut과 Advice를 빈에 적용
 * - 기본적인 런타임 프록시를 생성하며, Aspectj의 컴파일 타임 위빙과는 다름.
 *
 * - AspectJ란: AspectJ는 java용 AOP 프레임워크로, 강력한 PointCut 표현식과 다양한 위빙 방식을 제공
 *              스프링 AOP Aspectj의 문법(@Aspect, @Before)를 차용하지만, 전체 기능을 사용하지 않음
 *              AspectJ는 프록시 없이도 직접 바이트코드를 수정할 수 있어 더 유연하지만 설정이 복잡함.
 *
 * - 위빙(Weaving)이란: AOP에 Aspect(부가 기능)을 핵심 로직에 삽입하는 과정
 * - 컴파일 타임 위빙: Aspect에서 소스 코드를 컴파일할 때 바이트코드에 Aspect를 삽입
 * - 로드 타임 위빙: 클래스 로더가 클래스를 로드할 때 Aspect를 삽입
 * - 런타임 위빙: 스프링 AOP가 사용하는 방식으로, 런타임에 프록시 객체를 생성해 Aspect를 적용.
 * - 스프링 AOP는 런타임 위빙만 지원하며, 프록시를 통해 동작하므로 final 클래스나 private 메서드에 적용 불가
 */
@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.aop.section02")
@EnableAspectJAutoProxy //해당 빈을 프록시 객체로 변환
public class AppConfig {
}
