package by.psu.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import by.psu.dao.ActorDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class ActorDaoImpl implements ActorDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(ActorDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Actor obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Actor successfully saved. Actor details: " + obj);
    }

    public Actor getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Actor actor = session.load(Actor.class, id);
        LOGGER.info("Actor successfully loaded. Actor details: " + actor);

        return actor;
    }

    public void update(Actor obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Actor successfully updated. Actor details: " + obj);
    }

    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Actor actor = session.load(Actor.class, id);

        if (actor != null) {
            session.delete(actor);
        }

        LOGGER.info("Actor successfully removed. Actor details: " + actor);
    }

    @SuppressWarnings("unchecked")
    public List<Actor> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Actor> actorList = session.createQuery("from Actor").list();
        LOGGER.info("Actor list successfully loaded.");

        return actorList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Actor getByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Query<Actor> query = session.createQuery("from Actor as a where a.name =:name");
        query.setParameter("name", name);

        try {
            LOGGER.info("Actor successfully loaded. Actor details: " + query.getSingleResult());
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
