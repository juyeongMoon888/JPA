package com.ohgiraffers.inheritance.chap01.section04.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clothing_products_tpc")
public class ClothingProductTPC extends ProductTPC{
    private String size;
    private String metrial;
    private String color;

    protected ClothingProductTPC() {}

    public ClothingProductTPC(String name, double price, String brand, int stockQuantity, String size, String metrial, String color) {
        super(name, price, brand, stockQuantity);
        this.size = size;
        this.metrial = metrial;
        this.color = color;
    }

    @Override
    public String toString() {
        return "ClothingProductTPC{" +
                "size='" + size + '\'' +
                ", metrial='" + metrial + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
