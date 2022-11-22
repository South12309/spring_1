package com.gb.lesson_3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryBean {
    private SessionFactory sessionFactory;

    public SessionFactoryBean() {
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
