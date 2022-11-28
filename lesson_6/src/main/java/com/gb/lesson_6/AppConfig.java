package com.gb.lesson_6;

import com.gb.lesson_6.repository.ClientRepository;
import com.gb.lesson_6.repository.ClientRepositoryImpl;
import com.gb.lesson_6.repository.ProductRepositoryImpl;
import com.gb.lesson_6.services.ClientService;
import com.gb.lesson_6.services.ClientServiceImpl;
import com.gb.lesson_6.services.ProductService;
import com.gb.lesson_6.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.gb.lesson_6")
public class AppConfig {


    @Bean
    public ClientService clientService() {
        ClientService clientService = new ClientServiceImpl(new ClientRepositoryImpl(new SessionFactoryBean()));
        return clientService;
    }
    @Bean
    public ProductService productService() {
        ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl(new SessionFactoryBean()));
        return productService;
    }
}
