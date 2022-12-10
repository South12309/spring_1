package com.gb.lesson_7.repositoryes.specifications;

import com.gb.lesson_7.models.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductsSpecifications {
    public static Specification<Product> costGreaterOrEqualsThan(BigDecimal cost) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
            criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), cost);
    }

    public static Specification<Product> costLessOrEqualsThan(BigDecimal cost) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("cost"), cost);
    }
    public static Specification<Product> nameLike(String tittlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("tittle"), String.format("%%%s%%", tittlePart));
    }
}
