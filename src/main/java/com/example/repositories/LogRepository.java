package com.example.repositories;

import com.example.models.Log;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LogRepository {

    private final SessionFactory sessionFactory;

    @Transactional
    public List<Log> all() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Log").getResultList();
    }

    @Transactional
    public void add(Log log) {
        Session session = sessionFactory.getCurrentSession();
        session.save(log);
    }

    @Transactional
    public Log getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Log.class, id);
    }

    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Log log = getById(id);
        session.delete(log);
    }
}
