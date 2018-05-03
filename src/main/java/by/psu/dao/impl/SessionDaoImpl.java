package by.psu.dao.impl;

import java.time.LocalDate;
import java.util.List;

import by.psu.dao.SessionDao;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class SessionDaoImpl implements SessionDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(SessionDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Session obj) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Session successfully saved. Session details: " + obj);
    }

    public Session getById(int id) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Session filmSession = session.load(Session.class, id);
        LOGGER.info("Session successfully loaded. Session details: " + filmSession);

        return filmSession;
    }

    public void update(Session obj) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Session successfully updated. Session details: " + obj);
    }

    public void remove(int id) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Session filmSession = session.load(Session.class, id);

        if (filmSession != null) {
            session.delete(filmSession);
            LOGGER.info("Session successfully removed. Session details: " + filmSession);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Session> getAll() {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        List<Session> sessions = session.createQuery("from Session").list();
        LOGGER.info("Sessions list sucssesfully loaded.");

        return sessions;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Session> getFilmSessionsBycity(int filmId, int cityId) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Session> query = session.createQuery("from Session as s "
                + "where s.film.id =:filmId and "
                + "s.cinemaHall.cinema.city.id =:cityId and "
                + "s.date = s.film.dateStart");
        query.setParameter("filmId", filmId);
        query.setParameter("cityId", cityId);


        LOGGER.info("Film sessions successfully loaded");

        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Session> getFilmsSessionsByCityAndDate(int filmId, int cityId, LocalDate date) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Session> query = session.createQuery("from Session as s "
                + "where s.film.id =:filmId and "
                + "s.cinemaHall.cinema.city.id =:cityId and "
                + "s.date =:date");
        query.setParameter("filmId", filmId);
        query.setParameter("cityId", cityId);
        query.setParameter("date", date);

        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public int countFreePlaces(int sessionId) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Ticket> query = session.createQuery("from Ticket as t "
                + "where t.session.id = :sessionId");
        query.setParameter("sessionId", sessionId);

        return query.getResultList().size();
    }

}
