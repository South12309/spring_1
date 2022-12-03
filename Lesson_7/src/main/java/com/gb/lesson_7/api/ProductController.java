package com.gb.lesson_7.api;

import com.gb.lesson_7.models.Product;
import com.gb.lesson_7.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/app/products")
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
        for (int i = 1; i < 21; i++) {
            productService.addProduct(new Product(null,"product" +i, new BigDecimal(i*10)));
        }
    }

    @GetMapping()
    public List<Product> getAllProducts(@RequestParam(required = false) Integer min, @RequestParam(required = false) Integer max) {
        return productService.findProductsByCoastBetween(min, max);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/new")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/get_by_page")
    public List<Product> getPage(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize) {
        return productService.getPage(pageNumber, pageSize).toList();
    }

}
