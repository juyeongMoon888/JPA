-- 🏆 Module 3: 연관관계 매핑을 위한 데이터베이스

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS deliveries;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
SET FOREIGN_KEY_CHECKS = 1;

-- 1. Customers 테이블: '하나(One)'의 역할을 맡는 부모 엔티티
CREATE TABLE customers
(
    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL
) COMMENT '고객 정보';

-- 2. Orders 테이블: '다(Many)'의 역할을 맡는 자식 엔티티
CREATE TABLE orders
(
    order_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT   NOT NULL COMMENT 'customers 테이블을 참조하는 FK',
    order_date  DATETIME NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE
) COMMENT '주문 정보';

-- 3. Deliveries 테이블: '일대일(OneToOne)' 관계를 위한 엔티티
CREATE TABLE deliveries
(
    delivery_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id    BIGINT       NOT NULL UNIQUE COMMENT 'orders 테이블을 참조하는 FK이자 UNIQUE',
    address     VARCHAR(255) NOT NULL,
    status      VARCHAR(50)  NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE
) COMMENT '배송 정보';


-- 샘플 데이터 삽입
INSERT INTO customers (name) VALUES ('홍길동'), ('김영희');

INSERT INTO orders (customer_id, order_date) VALUES
                                                 (1, NOW()), (1, NOW() + INTERVAL 1 HOUR), -- 홍길동 고객의 주문 2건
                                                 (2, NOW()); -- 김영희 고객의 주문 1건

INSERT INTO deliveries (order_id, address, status) VALUES
                                                       (1, '서울시 강남구', 'READY'), -- 1번 주문의 배송 정보
                                                       (3, '부산시 해운대구', 'SHIPPED'); -- 3번 주문의 배송 정보


show tables;