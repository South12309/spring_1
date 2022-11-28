package com.gb.lesson_3.repository;

import com.gb.lesson_3.models.Product;
import org.hibernate.Session;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);
}
