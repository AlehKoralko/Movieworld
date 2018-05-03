package by.psu.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import by.psu.dao.CountryDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class CountryDaoImpl implements CountryDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(CountryDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Country obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Country successfully saved. Country details: " + obj);
    }

    public Country getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Country country = session.load(Country.class, id);
        LOGGER.info("Country successfully loaded. Country details: " + country);

        return country;
    }

    public void update(Country obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Country successfully updated. Country details: " + obj);
    }

    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Country country = session.load(Country.class, id);

        if (country != null) {
            session.delete(country);
        }

        LOGGER.info("Country successfully removed. Country details: " + country);
    }

    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
        Session session = sessionFactory.getCurrentSession();
        List<Country> countries = session.createQuery("from Country").list();
        LOGGER.info("Country list successfully loaded.");

        return countries;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Country getByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Query<Country> query = session.createQuery("from Country as c where c.name =:name");
        query.setParameter("name", name);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
