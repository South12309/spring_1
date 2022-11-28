package com.gb.lesson_6.services;

import com.gb.lesson_6.models.Client;
import com.gb.lesson_6.models.ClientsProducts;
import com.gb.lesson_6.models.Product;
import com.gb.lesson_6.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
@Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

@Override
    public List<Product> findClientProductsById(Long id) {
        List<Product> productList = clientRepository.findClientProductsById(id);
        return productList;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Client saveOrUpdate(Client client) {
        return null;
    }
}
