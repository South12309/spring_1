package com.gb.lesson_7.repositoryes;

import com.gb.lesson_7.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
//Optional<Product> findById(Long id);
    void deleteProductById(Long id);
    List<Product> findProductsByCostBetween(Integer min, Integer max);
    List<Product> findProductsByCostGreaterThan(Integer min);

}
