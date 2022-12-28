package com.gb.lesson_7.models;

import com.gb.lesson_7.dto.ProductDto;
import com.gb.lesson_7.dto.ProductDtoForCart;
import com.gb.lesson_7.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private Long cart_id=0L;

    public Long getCart_id() {
        cart_id++;
        return cart_id;
    }

    List<ProductDtoForCart> productDtoList = new ArrayList<>();

    public List<ProductDtoForCart> getAllProducts() {
        return productDtoList;
    }

    public void addProductToCart(ProductDtoForCart productDtoForCart) {

        productDtoForCart.setCart_id(getCart_id());
        productDtoList.add(productDtoForCart);
    }
    public void deleteProductFromCart(Long cart_id) {
        productDtoList.removeIf(s->s.getCart_id()==cart_id);
    }

}
