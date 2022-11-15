package com.gb.lesson_3.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private BigDecimal cost;

    public Product(Long id) {
        this.id=id;
    }

    @Override
    public String toString() {
        return id +" " + title + " цена:"+ cost;
    }
}