package com.gb.lesson_3.repository;

import com.gb.lesson_3.models.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryMemory implements ProductRepository{
    private final List<Product> products=new ArrayList<>();
    private static Long INDEX=0L;
    public static Long getINDEX() {
        return INDEX++;
    }

    @PostConstruct
    public void fillFirstRepository() {
        products.add(new Product(getINDEX(), "product1", new BigDecimal(100)));
        products.add(new Product(getINDEX(), "product2", new BigDecimal(120)));
        products.add(new Product(getINDEX(), "product3", new BigDecimal(10)));
        products.add(new Product(getINDEX(), "product4", new BigDecimal(1020)));
        products.add(new Product(getINDEX(), "product5", new BigDecimal(10045)));
    }

    public List<Product> findAll() {
        return products;
    }

    @Override
    public void deleteById(Long id) {

    }

    public Product findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().get();

    }

    public Product saveOrUpdate(Product product) {
        products.add(product);
        return product;
    }
}