package com.gb.lesson_3.services;

import com.gb.lesson_3.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveOrUpdateProduct(Product product);
    void deleteProduct(Long id);
}
