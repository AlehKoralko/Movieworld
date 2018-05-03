package by.psu.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import by.psu.dao.DirectorDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class DirectorDaoImpl implements DirectorDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(DirectorDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Director obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Director successfully saved. Director details: " + obj);
    }

    @Override
    public Director getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Director director = session.load(Director.class, id);
        LOGGER.info("Director successfully loaded. Director details: " + director);

        return director;
    }

    @Override
    public void update(Director obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Director successfully updated. Director details: " + obj);
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Director director = session.load(Director.class, id);

        if (director != null) {
            session.delete(director);
        }

        LOGGER.info("Director successfully removed. Director details: " + director);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Director> getAllDirectors() {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Director list successfully loaded.");

        return session.createQuery("from Director").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Director getByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Query<Director> query = session.createQuery("from Director as d where d.name =:name");
        query.setParameter("name", name);

        try {
            LOGGER.info("Director successfully loaded. Director details: " + query.getSingleResult());
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
