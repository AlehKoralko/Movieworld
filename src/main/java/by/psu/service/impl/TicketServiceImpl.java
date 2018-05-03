package by.psu.service.impl;

import by.psu.dao.PlaceDao;
import by.psu.dao.RowDao;
import by.psu.dao.TicketDao;
import by.psu.model.Place;
import by.psu.model.Row;
import by.psu.model.Ticket;
import by.psu.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private RowDao rowDao;

    @Autowired
    private PlaceDao placeDao;

    @Override
    @Transactional
    public void addTicket(Ticket order) {
        ticketDao.add(order);
    }

    @Override
    @Transactional
    public Ticket getTicketById(int ticketId) {
        return ticketDao.getById(ticketId);
    }

    @Override
    @Transactional
    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    @Override
    @Transactional
    public void deleteTicket(int id) {
        ticketDao.remove(id);
    }

    @Override
    @Transactional
    public List<Ticket> getAllTickets() {
        return ticketDao.getAllTickets();
    }

    @Override
    @Transactional
    public List<Row> getRowsByCinemaHall(int cinemaHallId, int sessionId, String username) {
        List<Row> rows = rowDao.getRowsByCinemaHall(cinemaHallId);

        for (Row row : rows) {
            for (Place place : row.getPlaces()) {
                if (placeDao.checkSessionStatus(place.getId(), sessionId)) {
                    place.setSessionStatus(1);
                    if (placeDao.checkSessionStatus(place.getId(), sessionId, username)) {
                        place.setSessionStatus(2);
                    }
                } else {
                    place.setSessionStatus(0);
                }
            }
        }

        return rows;
    }

    @Override
    @Transactional
    public Place getPlaceById(int placeId) {
        return placeDao.getById(placeId);
    }

    @Override
    @Transactional
    public Row getRowById(int rowId) {
        return rowDao.getById(rowId);
    }

}
