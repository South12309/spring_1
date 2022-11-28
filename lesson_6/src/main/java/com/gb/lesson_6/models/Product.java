package com.gb.lesson_6.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private BigDecimal cost;

    @OneToMany(mappedBy = "product")
    private List<ClientsProducts> clientsProducts;

    @Override
    public String toString() {
        return id +" " + title + " цена:"+ cost;
    }
}
