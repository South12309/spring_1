package com.gb.lesson_7.api;

import com.gb.lesson_7.dto.ProductDtoForCart;
import com.gb.lesson_7.mappers.ProductMapper;
import com.gb.lesson_7.models.Cart;
import com.gb.lesson_7.dto.ProductDto;
import com.gb.lesson_7.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@Slf4j
public class CartController {
    private final Cart cart;
    private final ProductService productService;
@Autowired
    public CartController(Cart cart, ProductService productService) {
        this.cart = cart;
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDtoForCart> getAllProductsFromCart() {
        return cart.getAllProducts();
    }

    @PostMapping
    public void addProductToCat(@RequestBody ProductDto productDto) {
        cart.addProductToCart(ProductMapper.MAPPER.fromProductDtoFromDtoCart(productDto));
    }

    @DeleteMapping("/{cart_id}")
    public void deleteProductFromCart(@PathVariable Long cart_id) {
        cart.deleteProductFromCart(cart_id);
    }

}
