package com.gb.lesson_6.services;

import com.gb.lesson_6.models.Client;
import com.gb.lesson_6.models.Product;
import com.gb.lesson_6.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
@Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Product saveOrUpdate(Product product) {
        return null;
    }

    @Override
    public List<Client> findProductClientsById(Long id) {
        return productRepository.findProductClientsById(id);
    }
}
