package by.psu.dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;

import by.psu.dao.FilmDao;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class FilmDaoImpl implements FilmDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(FilmDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Film obj) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Film successfully saved. Film details: " + obj);
    }

    @Override
    public Film getById(int id) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Film film = session.load(Film.class, id);

        LOGGER.info("Film successfully loaded. Film details: " + film);

        return film;
    }

    @Override
    public void update(Film obj) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Film successfully updated. Film details:" + obj);
    }

    @Override
    public void remove(int id) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Film film = session.load(Film.class, id);

        if (film != null) {
            session.delete(film);
        }

        LOGGER.info("Film successfully removed. Film details: " + film);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Film> getAllFilms() {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        List<Film> films = session.createQuery("from Film").list();

        LOGGER.info("Film list successfully loaded");
        films.forEach(f -> LOGGER.info("list details: " + f));

        return films;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Film> getFilmsByCity(int cityId) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Film> query = session.createQuery("from Film as f "
                + "where f.id in "
                + "(select distinct s.film.id "
                + "from Session s "
                + "where s.cinemaHall.cinema.city.id =:cityId)");
        query.setParameter("cityId", cityId);

        LOGGER.info("Films by City successfully loaded. City id = " + cityId);

        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> searchByName(String filmName) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Film> query = session.createQuery("from Film as f "
                + "where f.name like :filmName");
        query.setParameter("filmName", "%" + filmName + "%");

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> searchByActor(String actorName) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Film> query = session.createQuery("from Film as f "
                + "where f.id in "
                + "(select ff.id "
                + "from Actor as a join a.films ff "
                + "where a.name like :actorName)");
        query.setParameter("actorName", "%" + actorName + "%");

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> searchByGenre(String genreName) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Film> query = session.createQuery("from Film as f "
                + "where f.id in "
                + "(select ff.id "
                + "from Genre as g join g.films ff "
                + "where g.name like :genreName)");
        query.setParameter("genreName", "%" + genreName + "%");

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> searchByCity(String cityName) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<City> query = session.createQuery("from City as c "
                + "where c.name like :cityName");
        query.setParameter("cityName", "%" + cityName + "%");

        try {
            return this.getFilmsByCity(query.getSingleResult().getId());
        } catch (NoResultException e) {
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> searchByDirector(String directorName) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Film> query = session.createQuery("from Film as f "
                + "where f.id in "
                + "(select ff.id "
                + "from Director as d join d.films ff "
                + "where d.name like :directorName)");
        query.setParameter("directorName", "%" + directorName + "%");

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> searchByOperator(String operatorName) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Film> query = session.createQuery("from Film as f "
                + "where f.id in "
                + "(select ff.id "
                + "from Operator as o join o.films ff "
                + "where o.name like :operatorName)");
        query.setParameter("operatorName", "%" + operatorName + "%");

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> searchByYear(int year) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Film> query = session.createQuery("from Film as f "
                + "where f.year = :year");
        query.setParameter("year", year);

        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> searchByCountry(String countryName) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Film> query = session.createQuery("from Film as f "
                + "where f.id in "
                + "(select ff.id "
                + "from Country as c join c.films ff "
                + "where c.name like :countryName)");
        query.setParameter("countryName", "%" + countryName + "%");

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> searchByDate(LocalDate date) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Film> query = session.createQuery("from Film as f "
                + "where :date between f.dateStart and f.dateEnd");
        query.setParameter("date", date);

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
