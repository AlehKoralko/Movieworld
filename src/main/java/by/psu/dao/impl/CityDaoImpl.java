package by.psu.dao.impl;

import java.util.List;

import by.psu.dao.CityDao;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;


@Repository
public class CityDaoImpl implements CityDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(CityDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(City obj) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("City successfully saved. City details: " + obj);
    }

    public City getById(int id) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        City city = session.load(City.class, id);
        LOGGER.info("City successfully loaded. City details: " + city);

        return city;
    }

    public void update(City obj) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("City successfully updated. City details: " + obj);
    }

    public void remove(int id) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        City city = session.load(City.class, id);

        if (city != null) {
            session.delete(city);
        }
        LOGGER.info("City successfully removed. City details: " + city);
    }

    @SuppressWarnings("unchecked")
    public List<City> getAll() {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        List<City> cityList = session.createQuery("from City").list();

        cityList.forEach(city -> LOGGER.info("List details: " + city));

        return cityList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<City> getCitiesByFilmSession(int filmId) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<City> query = session.createQuery("from City c where c.id in "
                + "(select distinct s.cinemaHall.cinema.city.id "
                + "from Session s "
                + "where s.film.id =:filmId)");
        query.setParameter("filmId", filmId);

        return query.getResultList();
    }

}
