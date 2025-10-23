package com.ohgiraffers.chap01.section03.model;

import jakarta.persistence.*;

@Entity(name = "section03-delivery")
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "status", nullable = false)
    private String status;

    public Delivery() {

    }

    public Delivery(String address, String status) {
        this.address = address;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Order getOrder() {
        return order;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", order=" + order.getId() +
                ", status='" + status + '\'' +
                '}';
    }
}
