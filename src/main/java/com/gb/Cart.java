package com.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@Scope("prototype")
public class Cart {
    private final ProductRepository productRepository;
    private Map<Integer, Product> cart = new HashMap<>();
@Autowired
    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        cart.put(product.getId(), product);
    }

    public void deleteProduct(int id) {
        cart.remove(id);
    }
}
