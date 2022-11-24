package com.gb.lesson_6;


import com.gb.lesson_6.services.ClientService;
import com.gb.lesson_6.services.ClientServiceImpl;
import com.gb.lesson_6.services.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson6Application {




    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.gb.lesson_6");
        ClientService clientService = context.getBean("clientService", ClientService.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        SessionFactoryBean sessionFactoryBean = context.getBean("sessionFactoryBean", SessionFactoryBean.class);


        sessionFactoryBean.createAndFillDB();
        System.out.println("Products buy by client with id = 1: " + clientService.findClientProductsById(1L));
        System.out.println("Cleints who by product with id = 1: " + productService.findProductClientsById(1L));

    }


}
