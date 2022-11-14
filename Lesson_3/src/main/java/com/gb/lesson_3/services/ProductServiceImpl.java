package com.gb.lesson_3.services;

import com.gb.lesson_3.models.Product;
import com.gb.lesson_3.repository.ProductRepository;
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
        return productRepository.getProducts();
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
