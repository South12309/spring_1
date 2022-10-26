package com.gb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
public class Product {
    private int id;
    private String tittle;
    private Long price;
}
