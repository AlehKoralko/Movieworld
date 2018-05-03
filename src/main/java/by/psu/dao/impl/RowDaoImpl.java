package by.psu.dao.impl;

import java.util.List;

import by.psu.dao.RowDao;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class RowDaoImpl implements RowDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(RowDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Row obj) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Row successfully saved. Row details: " + obj);
    }

    public Row getById(int id) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Row row = session.load(Row.class, id);
        LOGGER.info("Row successfully loaded. Row details: " + row);

        return row;
    }

    public void update(Row obj) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Row successfully updated. Row details: " + obj);
    }

    public void remove(int id) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Row row = session.load(Row.class, id);

        if (row != null) {
            session.delete(row);
        }

        LOGGER.info("Row successfully removed. Row details: " + row);
    }

    @SuppressWarnings("unchecked")
    public List<Row> getAll() {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        List<Row> rowList = session.createQuery("from Row").list();
        LOGGER.info("Row list successfully loaded.");

        return rowList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Row> getRowsByCinemaHall(int cinemaHallId) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();

        Query<Row> query = session.createQuery("from Row as r "
                + "where r.cinemaHall.id =:cinemaHallId "
                + "order by id asc");
        query.setParameter("cinemaHallId", cinemaHallId);

        return query.getResultList();
    }

}
