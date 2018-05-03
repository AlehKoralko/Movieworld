package by.psu.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import by.psu.dao.GenreDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class GenreDaoImpl implements GenreDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(GenreDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Genre obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Genre successfully saved. Genre details: " + obj);
    }

    public Genre getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Genre genre = session.load(Genre.class, id);
        LOGGER.info("Genre successfully loaded. Genre details: " + genre);

        return genre;
    }

    public void update(Genre obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Genre successfully updated. Genre details: " + obj);
    }

    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Genre genre = session.load(Genre.class, id);

        if (genre != null) {
            session.delete(genre);
        }

        LOGGER.info("Genre successfully removed. Genre details: " + genre);
    }

    @SuppressWarnings("unchecked")
    public List<Genre> getAllGenres() {
        Session session = sessionFactory.getCurrentSession();
        List<Genre> genres = session.createQuery("from Genre").list();
        LOGGER.info("Genre list successfully loaded.");

        return genres;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Genre getByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Query<Genre> query = session.createQuery("from Genre as g where g.name =:name");
        query.setParameter("name", name);

        try {
            LOGGER.info("Genre successfully loaded. Genre details: " + query.getSingleResult());
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
