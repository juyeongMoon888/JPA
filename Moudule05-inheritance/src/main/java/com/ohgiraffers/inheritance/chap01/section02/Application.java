package com.ohgiraffers.inheritance.chap01.section02;

import com.ohgiraffers.inheritance.chap01.section02.model.ElectronicProduct;
import com.ohgiraffers.inheritance.chap01.section02.model.FoodProduct;
import com.ohgiraffers.inheritance.chap01.section02.model.ClothingProduct;
import com.ohgiraffers.inheritance.chap01.section02.model.Product;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Single_table 전략
 * - 모든 클래스를 하나의 테이블에 저장, Dtype 컬럼으로 클래스 구분
 * - 장점: 쿼리가 단순하고 빠름(조인 불필요)
 * - 단점: 자식 클래스의 컬럼이 많아지면 테이블이 비대해지고, null 값이 많아질 수 있음.
 *
 * DB에서 서브타입 엔티티 표현
 * - 데이터베이스에서는 모든 자식 클래스의 데이터가 하나의 테이블(products)에 저장됨.
 * - dtype 컬럼을 통해 각 행이 어떤 자식 클래스에 해당하는지 구분
 * - 예: Dtype이 "Electronic"이면 ElectronicProduct
 * - 서브타입 엔티티의 속성(warrantyPeriod, size, expirationDate 등)은 해당 행에서만 값이 채워지고,
 * 다른 서브 타입의 속성은 null로 남게 된다.
 */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-config");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            ElectronicProduct electronic = new ElectronicProduct("laptop", 999.88, "Theck", 40, 20, "99");
            em.persist(electronic);
            ClothingProduct clothing = new ClothingProduct("T-shirt", 18.88, "fashionBranhd", 100, "M", "cotton", "Blue");
            em.persist(clothing);

            FoodProduct food = new FoodProduct("milk", 2.00, "gfoof", 200, LocalDate.now().plusDays(7), true, "ero");

            em.flush();
            em.clear();

            System.out.println("모든 상품 조회");
            em.createQuery("SELECT p FROM Product p", Product.class)
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
