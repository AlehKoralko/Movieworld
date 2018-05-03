package by.psu.service;

import by.psu.model.Place;
import by.psu.model.Row;
import by.psu.model.Ticket;

import java.util.List;

public interface TicketService {

    void addTicket(Ticket ticket);

    Ticket getTicketById(int ticketId);

    void updateTicket(Ticket ticket);

    void deleteTicket(int id);

    List<Ticket> getAllTickets();

    List<Row> getRowsByCinemaHall(int cinemaHallId, int sessionId, String username);

    Place getPlaceById(int placeId);

    Row getRowById(int rowId);

}
