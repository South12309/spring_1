package com.gb.lesson_3.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    private Long id;
    private String tittle;
    private BigDecimal coast;

    @Override
    public String toString() {
        return id.toString() +" " + tittle + " цена:"+ coast.toString();
    }
}