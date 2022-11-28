package com.gb.lesson_6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SessionFactoryBean {
    private SessionFactory sessionFactory;

    public SessionFactoryBean() {
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory();

    }


    public void createAndFillDB() {
        Session session = getSession();
        session.beginTransaction();
        String sql;
        try {
            Path path = Paths.get("lesson_6","createAndFillDB.sql");
            Stream<String> lines = Files.lines(path);
            sql = lines.collect(Collectors.joining(" "));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        session.createNativeQuery(sql).executeUpdate();
        session.getTransaction().commit();
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
