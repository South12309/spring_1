package com.gb.lesson_3.services;

import com.gb.lesson_3.models.Product;
import com.gb.lesson_3.repository.ProductDao;
import com.gb.lesson_3.repository.ProductRepository;
import com.gb.lesson_3.repository.ProductRepositoryMemory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;



    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        productRepository.saveOrUpdate(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
