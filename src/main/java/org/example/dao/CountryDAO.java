package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.entity.CountryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@RequiredArgsConstructor
public class CountryDAO {

    private final SessionFactory sessionFactory;

    public List<CountryEntity> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<CountryEntity> query = session.createQuery("select c from CountryEntity c join fetch c.languages", CountryEntity.class);
        return query.list();
    }
}
