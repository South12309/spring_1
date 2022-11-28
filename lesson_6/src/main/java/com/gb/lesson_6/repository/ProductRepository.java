package com.gb.lesson_6.repository;


import com.gb.lesson_6.models.Client;
import com.gb.lesson_6.models.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);
    List<Client> findProductClientsById(Long id);
}
