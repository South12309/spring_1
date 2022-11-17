package com.gb.lesson_3.repository;

import com.gb.lesson_3.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDao implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Product findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, 1L);
        session.getTransaction().commit();
        return product;
    }
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        session.getTransaction().commit();
        return products;
    }
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, 1L);
        session.remove(product);
        session.getTransaction().commit();

    }
    public Product saveOrUpdate(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        return product;
    }
}
