package com.gb.lesson_6.services;

import com.gb.lesson_6.models.Client;
import com.gb.lesson_6.models.Product;

import java.util.List;


    public interface ClientService {
        Client findById(Long id);
        List<Client> findAll();
        void deleteById(Long id);
        Client saveOrUpdate(Client client);
        List<Product> findClientProductsById(Long id);
    }

