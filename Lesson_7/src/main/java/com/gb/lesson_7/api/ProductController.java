package com.gb.lesson_7.api;

import com.gb.lesson_7.dto.ProductDto;
import com.gb.lesson_7.mappers.ProductMapper;
import com.gb.lesson_7.models.Product;
import com.gb.lesson_7.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
        for (int i = 1; i < 21; i++) {
            productService.addProduct(new ProductDto(null,"product" +i, new BigDecimal(i*10)));
        }
    }

    @GetMapping
    public Page<ProductDto> getAllProducts(
            @RequestParam(name="p", defaultValue = "1") Integer page,
            @RequestParam(required = false) BigDecimal min,
            @RequestParam(required = false) BigDecimal max,
            @RequestParam(required = false) String tittlePart
    ) {
        if(page < 1){page = 1;}
        return productService.getAllProducts(min, max, tittlePart, page).map(s-> ProductMapper.MAPPER.fromProduct(s));
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {

        return ProductMapper.MAPPER.fromProduct(productService.getProduct(id));
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto) {

        return ProductMapper.MAPPER.fromProduct(productService.addProduct(productDto));
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {

        return ProductMapper.MAPPER.fromProduct(productService.updateProduct(productDto));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/get_by_page")
    public List<Product> getPage(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize) {
        return productService.getPage(pageNumber, pageSize).toList();
    }

}
