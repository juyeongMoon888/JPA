package com.ohgiraffers.springdata.chap02.controller;

import com.ohgiraffers.springdata.chap01.common.Product;
import com.ohgiraffers.springdata.chap02.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("chap01-section01-controller")
@RequestMapping("/chap02/section01/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable("productId") Integer productId) {
        System.out.println("controller get products " + productId);

        try {
            if (productId == null) {
                throw new IllegalArgumentException("상품 아이디는 null일 수 없습니다.");
            }
            Product product = productService.findProductById(productId);
            return ResponseEntity.ok(product);
        } catch (IllegalArgumentException e) {
            System.out.println("t상품 조회 실패" + e.getMessage());
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println("controller saveProduct " + product);

        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
}
