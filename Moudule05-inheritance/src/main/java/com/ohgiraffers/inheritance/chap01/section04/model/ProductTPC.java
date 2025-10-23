package com.ohgiraffers.inheritance.chap01.section04.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProductTPC {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator") //1차 캐싱에서 아이디 중복될 수 있기 때문에 sequence전략
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_id_seq", allocationSize = 1)
    @Column(name = "product_id")
    private Long id;

    private String name;
    private double price;
    private String brand;
    private int stockQuantity;

    protected ProductTPC() {}

    public ProductTPC(String name, double price, String brand, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.stockQuantity = stockQuantity;
    }


}
