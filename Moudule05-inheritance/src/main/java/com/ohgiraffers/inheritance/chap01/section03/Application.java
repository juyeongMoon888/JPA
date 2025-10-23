package com.ohgiraffers.inheritance.chap01.section03;

import com.ohgiraffers.inheritance.chap01.section03.model.ClothingProductJoined;
import com.ohgiraffers.inheritance.chap01.section03.model.ElectronicProductJoined;
import com.ohgiraffers.inheritance.chap01.section03.model.FoodProductJoined;
import com.ohgiraffers.inheritance.chap01.section03.model.ProductJoined;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

/**
 * joined 전략
 * - 부모와 자식 클래스를 각각 테이블로 나누고, 조인으로 연결
 * - 장점: 테이블이 정규화되어 데이터 중복이 되고, 각 테이블이 독립적
 * - 단점: 조회 시 조인이 필요하기 때문에 성능이 느려질 수 있음.
 */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-config");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            ElectronicProductJoined electronic = new ElectronicProductJoined("laptop", 999.88, "Theck", 40, 20, "99");
            em.persist(electronic);
            ClothingProductJoined clothing = new ClothingProductJoined("T-shirt", 18.88, "fashionBranhd", 100, "M", "cotton", "Blue");
            em.persist(clothing);

            FoodProductJoined food = new FoodProductJoined("milk", 2.00, "gfoof", 200, LocalDate.now().plusDays(7), true, "ero");

            em.flush();
            em.clear();

            System.out.println("모든 상품 조회");
            em.createQuery("SELECT p FROM ProductJoined p", ProductJoined.class)
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
