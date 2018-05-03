package by.psu.controller;

import by.psu.service.CityService;
import by.psu.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public String getAllFilms(Model model) {
        model.addAttribute("filmsList", filmService.getAllFilms());

        return "films";
    }

    @RequestMapping(value = "/films_by_city")
    public String getFilmsByCity(Model model, @RequestParam("cityId") int cityId) {
        model.addAttribute("filmsList", filmService.getFilmsByCity(cityId));
        model.addAttribute("city", cityService.getCityById(cityId));

        return "films_by_city";
    }

    @RequestMapping(value = "/film_info")
    public String filmInfo(Model model, @RequestParam("id") int id) {
        model.addAttribute("film", filmService.getFilmById(id));
        model.addAttribute("citiesList", cityService.getCitiesByFilmSession(id));

        return "film_info";
    }

    @RequestMapping(value = "/film_info_by_city")
    public String filmInfoByCity(Model model,
                                 @RequestParam("filmId") int filmId,
                                 @RequestParam("cityId") int cityId) {

        model.addAttribute("sessionsList", filmService.getFilmsSessionsByCity(filmId, cityId));
        model.addAttribute("film", filmService.getFilmById(filmId));
        model.addAttribute("city", cityService.getCityById(cityId));

        return "film_info_by_city";
    }

    @RequestMapping(value = "/film_info_by_city_and_date")
    public String filmInfoByCityAndDate(Model model,
                                        @RequestParam("filmId") int filmId,
                                        @RequestParam("cityId") int cityId,
                                        @RequestParam("date") String date) {

        model.addAttribute("sessionsList", filmService.getFilmsSessionsByCityAndDate(filmId, cityId, date));
        model.addAttribute("film", filmService.getFilmById(filmId));
        model.addAttribute("city", cityService.getCityById(cityId));

        return "film_info_by_city_and_date";
    }

    @RequestMapping(value = "/film_sessions_by_city")
    public String filmSessionsByCity(Model model,
                                     @RequestParam("filmId") int filmId,
                                     @RequestParam("cityId") int cityId) {

        model.addAttribute("sessionsList", filmService.getFilmsSessionsByCity(filmId, cityId));
        model.addAttribute("film", filmService.getFilmById(filmId));
        model.addAttribute("city", cityService.getCityById(cityId));

        return "film_sessions_by_city";
    }

    @RequestMapping(value = "/film_sessions_by_city_and_date")
    public String filmSessionsByCityAndDate(Model model,
                                            @RequestParam("filmId") int filmId,
                                            @RequestParam("cityId") int cityId,
                                            @RequestParam("date") String date) {

        model.addAttribute("sessionsList", filmService.getFilmsSessionsByCityAndDate(filmId, cityId, date));
        model.addAttribute("film", filmService.getFilmById(filmId));
        model.addAttribute("city", cityService.getCityById(cityId));

        return "film_sessions_by_city_and_date";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("searchQuery") String searchQuery, Model model) {
        model.addAttribute("filmsByName", filmService.searchByName(searchQuery));
        model.addAttribute("filmsByActor", filmService.searchByActor(searchQuery));
        model.addAttribute("filmByGenre", filmService.searchByGenre(searchQuery));
        model.addAttribute("filmsByCity", filmService.searchByCity(searchQuery));
        model.addAttribute("filmsByDirector", filmService.searchByDirector(searchQuery));
        model.addAttribute("filmsByOperator", filmService.searchByOperator(searchQuery));
        model.addAttribute("filmsByYear", filmService.searchByYear(searchQuery));
        model.addAttribute("filmsByCountries", filmService.searchByCountry(searchQuery));
        model.addAttribute("filmsByDate", filmService.searchByDate(searchQuery));

        model.addAttribute("searchQuery", searchQuery);

        return "search_result";
    }

    @RequestMapping(value = "/search_result", method = RequestMethod.GET)
    public String searchByFilmData(@RequestParam("searchQuery") String searchQuery, Model model) {
        model.addAttribute("filmsByName", filmService.searchByName(searchQuery));
        model.addAttribute("filmsByActor", filmService.searchByActor(searchQuery));
        model.addAttribute("filmByGenre", filmService.searchByGenre(searchQuery));
        model.addAttribute("filmsByCity", filmService.searchByCity(searchQuery));
        model.addAttribute("filmsByDirector", filmService.searchByDirector(searchQuery));
        model.addAttribute("filmsByOperator", filmService.searchByOperator(searchQuery));
        model.addAttribute("filmsByYear", filmService.searchByYear(searchQuery));
        model.addAttribute("filmsByCountries", filmService.searchByCountry(searchQuery));
        model.addAttribute("filmsByDate", filmService.searchByDate(searchQuery));
        model.addAttribute("searchQuery", searchQuery);

        return "search_result";
    }
}
