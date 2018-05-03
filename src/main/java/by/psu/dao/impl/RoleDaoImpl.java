package by.psu.dao.impl;

import java.util.List;

import by.psu.dao.RoleDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Role obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Role successfully saved. Role details: " + obj);
    }

    @Override
    public Role getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.load(Role.class, id);
        LOGGER.info("Role successfully loaded. Role details: " + role);

        return role;
    }

    @Override
    public void update(Role obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Role successfully updated. Role details: " + obj);
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.load(Role.class, id);

        if (role != null) {
            session.delete(role);
        }

        LOGGER.info("Role successfully removed. Role details: " + role);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> getAllRoles() {
        Session session = sessionFactory.getCurrentSession();
        List<Role> roles = session.createQuery("from Role").getResultList();

        for (Role role : roles) {
            LOGGER.info("List details: " + role);
        }

        return roles;
    }
}
