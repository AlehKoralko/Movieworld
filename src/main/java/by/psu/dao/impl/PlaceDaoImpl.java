package by.psu.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import by.psu.dao.PlaceDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class PlaceDaoImpl implements PlaceDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(PlaceDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Place obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Place successfully saved. Place details: " + obj);
    }

    public Place getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Place place = session.load(Place.class, id);
        LOGGER.info("Place successfully loaded. Place details: " + place);

        return place;
    }

    public void update(Place obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Place successfully updated. Place details: " + obj);
    }

    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Place place = session.load(Place.class, id);

        if (place != null) {
            session.delete(place);
        }
        LOGGER.info("Place successfully removed. Place details: " + place);
    }

    @SuppressWarnings("unchecked")
    public List<Place> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return (List<Place>) session.createQuery("from Place").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Boolean checkSessionStatus(int placeId, int sessionId) {
        Session session = sessionFactory.getCurrentSession();

        Query<Ticket> query = session.createQuery("from Ticket as t "
                + "where t.place.id =:placeId and "
                + "t.session.id =:sessionId");

        query.setParameter("placeId", placeId);
        query.setParameter("sessionId", sessionId);

        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Boolean checkSessionStatus(int placeId, int sessionId, String username) {
        Session session = sessionFactory.getCurrentSession();

        Query<Ticket> query = session.createQuery("from Ticket as t "
                + "where t.place.id =:placeId and "
                + "t.session.id =:sessionId and "
                + "t.user.username =:username");

        query.setParameter("placeId", placeId);
        query.setParameter("sessionId", sessionId);
        query.setParameter("username", username);

        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
}
