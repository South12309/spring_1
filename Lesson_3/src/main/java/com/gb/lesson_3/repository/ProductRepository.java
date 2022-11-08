package com.gb.lesson_3.repository;

import com.gb.lesson_3.models.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductRepository {
    private final List<Product> products=new ArrayList<>();

    @PostConstruct
    public void fillFirstRepository() {
        products.add(new Product(1L, "product1", new BigDecimal(100)));
        products.add(new Product(2L, "product2", new BigDecimal(120)));
        products.add(new Product(3L, "product3", new BigDecimal(10)));
        products.add(new Product(4L, "product4", new BigDecimal(1020)));
        products.add(new Product(5L, "product5", new BigDecimal(10045)));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().get();

    }

    public void addProduct(Product product) {
        products.add(product);
    }
}