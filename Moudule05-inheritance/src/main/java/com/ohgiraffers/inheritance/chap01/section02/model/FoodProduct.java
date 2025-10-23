package com.ohgiraffers.inheritance.chap01.section02.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("FOOD")
public class FoodProduct extends Product{

    private LocalDate expirationDte;
    private boolean isOrganic;
    private String storageInstruction;

    protected FoodProduct() {}

    public FoodProduct(String name, double price, String brand, int stockQuantity, LocalDate expirationDte, boolean isOrganic, String storageInstruction) {
        super(name, price, brand, stockQuantity);
        this.expirationDte = expirationDte;
        this.isOrganic = isOrganic;
        this.storageInstruction = storageInstruction;
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "expirationDte=" + expirationDte +
                ", isOrganic=" + isOrganic +
                ", storageInstruction='" + storageInstruction + '\'' +
                '}';
    }
}
