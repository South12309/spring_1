package com.gb.lesson_3;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lesson3Application {

    @Bean
    public SessionFactory sessionFactory() {
        SessionFactory sessionFactory = new Configuration()
                .buildSessionFactory();
        return sessionFactory;
    }
    public static void main(String[] args) {
        SpringApplication.run(Lesson3Application.class, args);
    }

}
