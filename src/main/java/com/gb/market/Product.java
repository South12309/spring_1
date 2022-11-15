package com.gb.market;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private Integer id;
    private String tittle;
    private Long price;

    @Override
    public String toString() {
        return id.toString() +" " + tittle + " цена:"+price.toString();
    }
}
