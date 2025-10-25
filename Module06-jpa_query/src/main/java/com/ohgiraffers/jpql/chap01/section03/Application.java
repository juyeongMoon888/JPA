package com.ohgiraffers.jpql.chap01.section03;

import com.ohgiraffers.jpql.chap01.model.Course;
import com.ohgiraffers.jpql.chap01.model.Lesson;
import jakarta.persistence.*;

/**
 * TypeQuery
 * - 타입 안정성: 결과를 제네릭 타입으로 지정하여 컴파일 시점에 타입 오류를 감지할 수 있다.
 * - 객체 중심적 접근: 쿼리 결과를 직접 지정한 엔티티 클래스를 매핑하여 불필요한 형변환 없이 바로 사용할 수 있다.
 * - 가독성 향상: 코드의 카독성의 높아지고, 의도를 명확히 전달할 수 있다.
 */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-config");
        EntityManager em = emf.createEntityManager();

        String sql = "SELECT c FROM Course c WHERE price >= 300";
        //Query course = em.createQuery(sql); // Query 타입으로 쓰면 어떤 클래스를 받는지 보장받고 사용할 수 없음
        //TypedQuery<Course> course = em.createQuery(sql, Lesson.class); //반환 타입 오류 컴파일단계

        TypedQuery<Course> courses = em.createQuery(sql, Course.class);

        System.out.println("단일 테이블 조회");
    }


}
