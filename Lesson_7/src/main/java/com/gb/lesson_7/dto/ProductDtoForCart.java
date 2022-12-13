package com.gb.lesson_7.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoForCart {
    private Long cart_id;
    private Long id;
    private String title;
    private BigDecimal cost;
//    public ProductDto(Product s) {
//        this.id=s.getId();
//        this.title=s.getTitle();
//        this.cost=s.getCost();
//    }
}
