package com.gb.lesson_3.repository;

import com.gb.lesson_3.SessionFactoryBean;
import com.gb.lesson_3.models.Product;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao implements ProductRepository {

private final SessionFactoryBean sessionFactory;
@Autowired
    public ProductDao(SessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Product findById(Long id) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, 1L);
        session.getTransaction().commit();
        return product;
    }
    public List<Product> findAll() {
        Session session = sessionFactory.getSession();

        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        session.getTransaction().commit();
        return products;
    }
    public void deleteById(Long id) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.createQuery("delete from products where id=:id").
                setParameter("id", id).
                executeUpdate();
        session.getTransaction().commit();

    }
    public Product saveOrUpdate(Product product) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        return product;
    }
}
