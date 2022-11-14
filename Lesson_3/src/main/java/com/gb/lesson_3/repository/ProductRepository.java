package com.gb.lesson_3.repository;

import com.gb.lesson_3.models.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {
    private final List<Product> products=new ArrayList<>();
    private static int INDEX=0;
    public static int getINDEX() {
        return INDEX++;
    }

    @PostConstruct
    public void fillFirstRepository() {
        products.add(new Product(getINDEX(), "product1",100));
        products.add(new Product(getINDEX(), "product2", 120));
        products.add(new Product(getINDEX(), "product3", 10));
        products.add(new Product(getINDEX(), "product4", 1020));
        products.add(new Product(getINDEX(), "product5", 10045));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream().filter(product -> product.getId()==id).findFirst().get();

    }

    public void addProduct(Product product) {
        products.add(product);
    }
}