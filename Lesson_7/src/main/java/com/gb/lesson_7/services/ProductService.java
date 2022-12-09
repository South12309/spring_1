package com.gb.lesson_7.services;

import com.gb.lesson_7.models.Product;
import com.gb.lesson_7.repositoryes.ProductRepository;
import com.gb.lesson_7.repositoryes.specifications.ProductsSpecifications;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Page<Product> getAllProducts(BigDecimal minCost, BigDecimal maxCost, String titlePart, Integer page) {
        Specification<Product> spec = Specification.where(null);
        if (minCost!=null) {
            spec=spec.and(ProductsSpecifications.costLessOrEqualsThan(minCost));
        }
        if (maxCost!=null) {
            spec=spec.and(ProductsSpecifications.costGreaterOrEqualsThan(maxCost));
        }
        if (titlePart!=null) {
            spec=spec.and(ProductsSpecifications.nameLike(titlePart));
        }

        return productRepository.findAll(spec,PageRequest.of(page-1,10));
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
