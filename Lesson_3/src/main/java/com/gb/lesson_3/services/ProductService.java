package com.gb.lesson_3.services;

import com.gb.lesson_3.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void addProduct(Product product);
}
