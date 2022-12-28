package com.gb.lesson_7.dto;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private BigDecimal cost;
//    public ProductDto(Product s) {
//        this.id=s.getId();
//        this.title=s.getTitle();
//        this.cost=s.getCost();
//    }
}
