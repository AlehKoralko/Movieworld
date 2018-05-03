package by.psu.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import by.psu.dao.UserDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("User successfully saved. User details: " + obj);
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        LOGGER.info("User successfully loaded. User details: " + user);

        return user;
    }

    @Override
    public void update(User obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("User successfully updated. User details: " + obj);
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);

        if (user != null) {
            session.delete(user);
        }

        LOGGER.info("User successfully removed. User details: " + user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User").getResultList();

        for (User user : users) {
            LOGGER.info("List details: " + user);
        }

        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User as u where u.username =:username");
        query.setParameter("username", username);

        try {
            LOGGER.info("User successfully loaded. User details: " + query.getSingleResult());
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
