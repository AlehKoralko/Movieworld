package by.psu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.psu.service.*;
import by.psu.model.*;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CityService cityService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/ordering")
    public String ordering(Model model,
                           @RequestParam("sessionId") int sessionId,
                           @RequestParam("cinemaHallId") int cinemaHallId,
                           @RequestParam("cityId") int cityId,
                           @RequestParam("username") String username) {

        model.addAttribute("session", sessionService.getSessionById(sessionId));
        model.addAttribute("city", cityService.getCityById(cityId));
        model.addAttribute("rows", ticketService.getRowsByCinemaHall(cinemaHallId, sessionId, username));

        return "ordering";
    }

    @RequestMapping(value = "/confirmation_order", method = RequestMethod.GET)
    public String confirmationOrder(Model model,
                                    @RequestParam("sessionId") int sessionId,
                                    @RequestParam("cinemaHallId") int cinemaHallId,
                                    @RequestParam("cityId") int cityId,
                                    @RequestParam("placeId") int placeId,
                                    @RequestParam("rowId") int rowId,
                                    @RequestParam("username") String username) {

        model.addAttribute("session", sessionService.getSessionById(sessionId));
        model.addAttribute("city", cityService.getCityById(cityId));
        model.addAttribute("rows", ticketService.getRowsByCinemaHall(cinemaHallId, sessionId, username));
        model.addAttribute("place", ticketService.getPlaceById(placeId));
        model.addAttribute("row", ticketService.getRowById(rowId));

        return "confirmation_order";
    }

    @RequestMapping(value = "/order/add")
    public String confirmationOrder(Model model,
                                    @RequestParam("username") String username,
                                    @RequestParam("placeId") int placeId,
                                    @RequestParam("sessionId") int sessionId) {

        model.addAttribute("sessionId", sessionId);
        model.addAttribute("cinemaHallId", sessionService
                .getSessionById(sessionId).getCinemaHall().getId());
        model.addAttribute("cityId", sessionService
                .getSessionById(sessionId)
                .getCinemaHall().getCinema().getCity().getId());
        model.addAttribute("username", username);

        User user = userService.getByUsername(username);
        Place place = ticketService.getPlaceById(placeId);
        Session session = sessionService.getSessionById(sessionId);

        Ticket ticket = new Ticket(user, place, session);

        ticketService.addTicket(ticket);

        return "redirect:/ordering?sessionId={sessionId}&cinemaHallId"
                + "={cinemaHallId}&cityId={cityId}&username={username}";
    }
}
