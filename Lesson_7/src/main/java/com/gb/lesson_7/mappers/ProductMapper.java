package com.gb.lesson_7.mappers;

import com.gb.lesson_7.dto.ProductDto;
import com.gb.lesson_7.dto.ProductDtoForCart;
import com.gb.lesson_7.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    Product toProduct(ProductDto productDto);
    ProductDto fromProduct(Product product);

    ProductDto toProductDtoFromDtoCart(ProductDtoForCart productDtoForCart);
    ProductDtoForCart fromProductDtoFromDtoCart(ProductDto productDto);
    List<ProductDto> toProductDtoFromDtoCartList(List<ProductDtoForCart> productDtoForCartList);
    List<ProductDtoForCart> fromProductDtoFromDtoCartList(List<ProductDto> productDtoList);
    List<Product> toProductList(List<ProductDto> productDtoList);
    List<ProductDto> fromProductList(List<Product> productList);
}
