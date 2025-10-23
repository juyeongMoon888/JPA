package com.ohgiraffers.chap01.section03.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "section03-order")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "customer_id")
    private int customer;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Delivery delivery;

    @Column(name = "order_date")
    private LocalDateTime orderDate = LocalDateTime.now();

    public Order()  {}

    public Order(int customer) {
        this.customer = customer;
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", delivery=" + delivery +
                ", orderDate=" + orderDate +
                '}';
    }
}
