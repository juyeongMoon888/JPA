package com.ohgiraffers.inheritance.chap01.section03.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "food_products_joined")
@DiscriminatorValue("FOOD")
public class FoodProductJoined extends ProductJoined{
    private LocalDate expirationDate;
    private boolean isOrganic;
    private String storageInstruction;

    protected  FoodProductJoined() {
    }

    public FoodProductJoined(String name, double price, String brand, int stockQuantity, LocalDate expirationDate, boolean isOrganic, String storageInstruction) {
        super(name, price, brand, stockQuantity);
        this.expirationDate = expirationDate;
        this.isOrganic = isOrganic;
        this.storageInstruction = storageInstruction;
    }
}
