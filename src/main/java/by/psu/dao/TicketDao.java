package by.psu.dao;

import by.psu.model.Ticket;

import java.util.List;

public interface TicketDao extends CrudDao<Ticket> {

    List<Ticket> getAllTickets();

}
