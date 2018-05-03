package by.psu.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import by.psu.dao.OperatorDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class OperatorDaoImpl implements OperatorDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(OperatorDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Operator obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Operator successfully saved. Operator details: " + obj);
    }

    public Operator getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Operator operator = session.load(Operator.class, id);
        LOGGER.info("Operator successfully loaded. Operator details: " + operator);

        return operator;
    }

    public void update(Operator obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Operator successfully updated. Operator details: " + obj);
    }

    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Operator operator = session.load(Operator.class, id);

        if (operator != null) {
            session.delete(operator);
        }

        LOGGER.info("Operator successfully removed. Operator details: " + operator);
    }

    @SuppressWarnings("unchecked")
    public List<Operator> getAllOperators() {
        Session session = sessionFactory.getCurrentSession();
        List<Operator> operators = session.createQuery("from Operator").list();
        LOGGER.info("Operator list successfully loaded.");

        return operators;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Operator getByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Query<Operator> query = session.createQuery("from Operator as o where o.name =:name");
        query.setParameter("name", name);

        try {
            LOGGER.info("Operator successfully loaded. Operator details: " + query.getSingleResult());
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
