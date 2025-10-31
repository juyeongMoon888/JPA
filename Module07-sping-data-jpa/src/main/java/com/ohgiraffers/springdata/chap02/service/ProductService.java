package com.ohgiraffers.springdata.chap02.service;

import com.ohgiraffers.springdata.chap01.common.Product;
import com.ohgiraffers.springdata.chap02.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("chap01-section01-service")
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Product findProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);

        Product findProduct = product.orElseThrow(() -> new IllegalArgumentException("id에 해당하는 제품이 없습니다."));
        return findProduct;
    }


    //이렇게 쓰면안된다.
    @Transactional
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }
}
