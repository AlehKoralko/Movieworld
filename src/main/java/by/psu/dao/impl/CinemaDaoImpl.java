package by.psu.dao.impl;

import java.util.List;

import by.psu.dao.CinemaDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class CinemaDaoImpl implements CinemaDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Cinema obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
    }

    public Cinema getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.load(Cinema.class, id);
    }

    public void update(Cinema obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
    }

    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Cinema cinema = session.load(Cinema.class, id);

        if (cinema != null) {
            session.delete(cinema);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Cinema> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return (List<Cinema>) session.createQuery("from Cinema").list();
    }

    @SuppressWarnings("unchecked")
    public List<Cinema> getByCity(int cityId) {
        Session session = sessionFactory.getCurrentSession();

        Query<Cinema> query = session.createQuery("select c.cinemas from City as c where c.id =:cityId");
        query.setParameter("cityId", cityId);

        List<Cinema> cinemas = query.getResultList();

        return cinemas;
    }

}
