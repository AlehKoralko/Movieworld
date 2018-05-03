package by.psu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.psu.service.CityService;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public String getAllCities(Model model) {
        model.addAttribute("citiesList", cityService.getAllCities());

        return "cities";
    }

    @RequestMapping(value = "/city_info")
    public String cityInfo(Model model, @RequestParam("cityId") int cityId) {
        model.addAttribute("city", cityService.getCityById(cityId));
        model.addAttribute("cinemas", cityService.getCinemasByCity(cityId));

        return "city_info";
    }
}
