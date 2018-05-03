package by.psu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.psu.service.CinemaService;

@Controller
@RequestMapping("cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllCinema(Model model) {
        model.addAttribute("cinamasList", cinemaService.getAllCinemas());

        model.addAttribute("cinemasListByCity", cinemaService.getByCityId(1));

        return "cinemas";
    }
}
