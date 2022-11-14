package com.gb.lesson_3.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private String title;
    private float cost;

    public Product(int id) {
        this.id=id;
    }

    @Override
    public String toString() {
        return id +" " + title + " цена:"+ cost;
    }
}