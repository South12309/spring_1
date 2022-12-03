package com.gb.lesson_7.services;

import com.gb.lesson_7.models.Product;
import com.gb.lesson_7.repositoryes.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

    public List<Product> findProductsByCoastBetween(Integer min, Integer max) {
        if (min == null) {
            min = 0;
        }
        if (max == null) {
            return productRepository.findProductsByCostGreaterThan(min);
        } else {
            return productRepository.findProductsByCostBetween(min, max);
        }
    }

    public Page<Product> getPage(Integer offset, Integer limit) {
        return productRepository.findAll(PageRequest.of(offset, limit, Sort.by(Sort.Direction.ASC, "id")));

    }
}
