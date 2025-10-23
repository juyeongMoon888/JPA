package com.ohgiraffers.inheritance.chap01.section04;


import com.ohgiraffers.inheritance.chap01.section04.model.ClothingProductTPC;
import com.ohgiraffers.inheritance.chap01.section04.model.ElectronicProductTPC;
import com.ohgiraffers.inheritance.chap01.section04.model.FoodProductTPC;
import com.ohgiraffers.inheritance.chap01.section04.model.ProductTPC;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

/**
 * Table_per_class 전략 설명
 * - 각 클래스를 별도의 테이블로 저장
 * - 장점: 조인이 없으므로 조회 성능이 빠르다.
 * - 단점: 공통 속성이 중복 저장되기 때문에 저장공간에 낭비가 발생된다.
 *      - 공통 속성 변경 시 모든 테이블 수정을 요구하게 된다.
 */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-config");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            ElectronicProductTPC electronic = new ElectronicProductTPC("laptop", 999.88, "Theck", 40, 20, "99");
            em.persist(electronic);
            ClothingProductTPC clothing = new ClothingProductTPC("T-shirt", 18.88, "fashionBranhd", 100, "M", "cotton", "Blue");
            em.persist(clothing);
            FoodProductTPC food = new FoodProductTPC("milk", 2.00, "gfoof", 200, LocalDate.now().plusDays(7), true, "ero");
            em.persist(food);

            em.flush();
            em.clear();

            em.createQuery("SELECT p from FoodProductTPC p", FoodProductTPC.class)
                            .getResultList().forEach(System.out::println);

            System.out.println("모든 상품 조회");
            em.createQuery("SELECT p FROM ProductTPC p", ProductTPC.class)
                    .getResultList()
                    .forEach(System.out::println);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
