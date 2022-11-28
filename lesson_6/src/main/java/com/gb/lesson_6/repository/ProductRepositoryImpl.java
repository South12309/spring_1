package com.gb.lesson_6.repository;

import com.gb.lesson_6.SessionFactoryBean;
import com.gb.lesson_6.models.Client;
import com.gb.lesson_6.models.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private SessionFactoryBean sessionFactoryBean;
@Autowired
    public ProductRepositoryImpl(SessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Product saveOrUpdate(Product product) {
        return null;
    }

    @Override
    public List<Client> findProductClientsById(Long id) {
        Session session = sessionFactoryBean.getSession();
        session.beginTransaction();
        List<Client> clientList = session.createQuery("SELECT c FROM Client c where c.id in (select cp.client.id from ClientsProducts cp where cp.product.id=:id)", Client.class).setParameter("id", id).getResultList();
        session.getTransaction().commit();
        return clientList;
    }
}
