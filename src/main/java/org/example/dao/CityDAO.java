package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.entity.CityEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@RequiredArgsConstructor
public class CityDAO {

    private final SessionFactory sessionFactory;

    public CityEntity getById(Integer id) {
        Query<CityEntity> query = sessionFactory.getCurrentSession()
                .createQuery("select c from CityEntity c join fetch c.country where c.id = :ID", CityEntity.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }
    public List<CityEntity> getItems(int offset, int limit) {
        Session session = sessionFactory.getCurrentSession();
        Query<CityEntity> query = session.createQuery("select c from CityEntity c", CityEntity.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    public int getTotalCount() {
        Session session = sessionFactory.getCurrentSession();
        Query<Long> query = session.createQuery("select count(c) from CityEntity c", Long.class);
        return Math.toIntExact(query.uniqueResult());
    }
}
