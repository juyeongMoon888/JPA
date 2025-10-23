package com.ohgiraffers.valueobject.chap02.section02;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class AvailableSize {

    @Column(name = "label")
    private String label;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    protected AvailableSize() {

    }

    public AvailableSize(String label, int stockQuantity) {
        if (label == null|| label.trim().isEmpty()) {
            throw new IllegalArgumentException("사이즈 라벨은 필수입니다.");
        }
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("재고 수량은 0 이상이어야 합니다.");
        }
        this.label = label;
        this.stockQuantity = stockQuantity;
    }

    public String getLabel() {
        return label;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * decreaseStock 메서드
     * - 해당 사이즈 재고 수량을 주어진 quantity 만큼 감소
     * @param quantity 주문 수량
     * @return void
     */
    public void decreaseStock(int quantity) {
        if(this.stockQuantity - quantity < 0) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.stockQuantity -= quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        AvailableSize that = (AvailableSize) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "AvailableSize{" +
                "label='" + label + '\'' +
                "(재고=" + stockQuantity +
                ')';
    }
}

