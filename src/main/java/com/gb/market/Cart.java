package com.gb.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {
    private final ProductRepository productRepository;
    private final Map<Integer, Product> cart = new HashMap<>();
@Autowired
    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id) {
        Product product = productRepository.getProductById(id);
        cart.put(product.getId(), product);
    }

    public void deleteProduct(int id) {
        cart.remove(id);
    }

    public void printProducts() {
    cart.forEach((key, value) -> System.out.println(value.toString()));
    }
}
