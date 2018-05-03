package by.psu.dao.impl;

import java.util.List;

import by.psu.dao.CinemaHallDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.CinemaHall;

@Repository
public class CinemaHallDaoImpl implements CinemaHallDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(CinemaHallDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(CinemaHall obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("CinemaHall successfully saved. CinemaHall details: " + obj);
    }

    public CinemaHall getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        CinemaHall cinemaHall = session.load(CinemaHall.class, id);
        LOGGER.info("CinemaHall successfully loaded. CinemaHall details: " + cinemaHall);

        return cinemaHall;
    }

    public void update(CinemaHall obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("CinemaHall successfully updated. CinemaHall details: " + obj);
    }

    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        CinemaHall cinemaHall = session.load(CinemaHall.class, id);

        if (cinemaHall != null) {
            session.delete(cinemaHall);
        }

        LOGGER.info("CinemaHall successfully removed. CinemaHall details: " + cinemaHall);
    }

    @SuppressWarnings("unchecked")
    public List<CinemaHall> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<CinemaHall> cinemaHallList = session.createQuery("from CinemaHall").list();
        LOGGER.info("CinemaHall list successfully loaded.");

        return cinemaHallList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CinemaHall> getCinemaHallsByCinema(int cinemaId) {
        Session session = sessionFactory.getCurrentSession();

        Query<CinemaHall> query = session.createQuery("from CinemaHall c where c.cinema.id =:cinemaId");
        query.setParameter("cinemaId", cinemaId);

        return query.getResultList();
    }

}
