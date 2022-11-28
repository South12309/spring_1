package com.gb.lesson_6.repository;

import com.gb.lesson_6.SessionFactoryBean;
import com.gb.lesson_6.models.Client;
import com.gb.lesson_6.models.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    private SessionFactoryBean sessionFactoryBean;

    @Autowired
    public ClientRepositoryImpl(SessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
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

    @Override
    public List<Product> findClientProductsById(Long id) {
        Session session = sessionFactoryBean.getSession();
        session.beginTransaction();
        List<Product> productList = session.createQuery("SELECT p FROM Product p where p.id in (select cp.product.id from ClientsProducts cp where cp.client.id=:id)", Product.class).setParameter("id", id).getResultList();
        session.getTransaction().commit();
        return productList;
    }

}
