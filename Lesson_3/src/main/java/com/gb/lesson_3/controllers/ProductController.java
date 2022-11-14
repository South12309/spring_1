package com.gb.lesson_3.controllers;

import com.gb.lesson_3.models.Product;
import com.gb.lesson_3.repository.ProductRepository;
import com.gb.lesson_3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "products";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product(ProductRepository.getINDEX()));
        return "new_product";
    }

    @PostMapping("/new")
    public String addProduct(@ModelAttribute("product")Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }
}
