package by.psu.dao.impl;

import java.util.List;

import by.psu.dao.TicketDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import by.psu.model.*;

@Repository
public class TicketDaoImpl implements TicketDao {

    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(TicketDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Ticket obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
        LOGGER.info("Ticket successfully saved. Ticket details: " + obj);
    }

    @Override
    public Ticket getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Ticket ticket = (Ticket) session.load(Ticket.class, id);
        LOGGER.info("Ticket successfully loaded. Ticket details: " + ticket);

        return ticket;
    }

    @Override
    public void update(Ticket obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
        LOGGER.info("Ticket successfully updated. Ticket details: " + obj);
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Ticket ticket = (Ticket) session.load(Ticket.class, id);

        if (ticket != null) {
            session.delete(ticket);
        }

        LOGGER.info("Ticket successfully removed. Ticket details: " + ticket);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Ticket> getAllTickets() {
        Session session = sessionFactory.getCurrentSession();
        List<Ticket> orders = session.createQuery("from Order").getResultList();
        LOGGER.info("Ticket list successfully loaded.");

        return orders;
    }
}
