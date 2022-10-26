package com.gb;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void fillFirstRepository() {
        products.add(new Product(1, "product1", 100L));
        products.add(new Product(2, "product2", 120L));
        products.add(new Product(3, "product3", 10L));
        products.add(new Product(4, "product4", 1020L));
        products.add(new Product(5, "product5", 10045L));
    }

public List<Product> getProducts() {
    return products;
}

public Product getProductById(int id) {
    return products.stream().filter(product -> product.getId() == id).findFirst().get();

}
 }
