package by.psu.controller;

import by.psu.dto.FilmForm;
import by.psu.model.*;
import by.psu.service.*;
import by.psu.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private FilmFormValidator filmFormValidator;

    @Autowired
    private SessionValidator sessionValidator;

    @Autowired
    private ActorValidator actorValidator;

    @Autowired
    private CountryValidator countryValidator;

    @Autowired
    private DirectorValidator directorValidator;

    @Autowired
    private GenreValidator genreValidator;

    @Autowired
    private OperatorValidator operatorValidator;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/admin_actors", method = RequestMethod.GET)
    public String getAllActors(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        model.addAttribute("actor", new Actor());

        return "admin_actors";
    }

    @RequestMapping(value = "/admin_countries", method = RequestMethod.GET)
    public String getAllCountries(Model model) {
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("country", new Country());

        return "admin_countries";
    }

    @RequestMapping(value = "/admin_directors", method = RequestMethod.GET)
    public String getAllDirectors(Model model) {
        model.addAttribute("directors", directorService.getAllDirectors());
        model.addAttribute("director", new Director());

        return "admin_directors";
    }

    @RequestMapping(value = "/admin_genres", method = RequestMethod.GET)
    public String getAllGenres(Model model) {
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("genre", new Genre());

        return "admin_genres";
    }

    @RequestMapping(value = "/admin_operators", method = RequestMethod.GET)
    public String getAllOperators(Model model) {
        model.addAttribute("operators", operatorService.getAllOperators());
        model.addAttribute("operator", new Operator());

        return "admin_operators";
    }

    @RequestMapping(value = "/admin_actors/edit", method = RequestMethod.POST)
    public String addActor(@ModelAttribute("actor") Actor actor) {
        actorService.updateActor(actor);

        return "redirect:/admin_actors";
    }

    @RequestMapping(value = "/admin_countries/edit", method = RequestMethod.POST)
    public String addCountry(@ModelAttribute("country") Country country) {
        countryService.updateCountry(country);

        return "redirect:/admin_countries";
    }

    @RequestMapping(value = "/admin_directors/edit", method = RequestMethod.POST)
    public String addDirector(@ModelAttribute("director") Director director) {
        directorService.updateDirector(director);

        return "redirect:/admin_directors";
    }

    @RequestMapping(value = "/admin_genres/edit", method = RequestMethod.POST)
    public String addGenre(@ModelAttribute("director") Genre genre) {
        genreService.updateGenre(genre);

        return "redirect:/admin_genres";
    }

    @RequestMapping(value = "/admin_operators/edit", method = RequestMethod.POST)
    public String addOperator(@ModelAttribute("operator") Operator operator) {
        operatorService.updateOperator(operator);

        return "redirect:/admin_operators";
    }

    @RequestMapping(value = "/remove_actor")
    public String removeActor(@RequestParam("actorId") int actorId) {
        actorService.removeActor(actorId);

        return "redirect:/admin_actors";
    }

    @RequestMapping(value = "/remove_country")
    public String removeCountry(@RequestParam("countryId") int countryId) {
        countryService.removeCountry(countryId);

        return "redirect:/admin_countries";
    }

    @RequestMapping(value = "/remove_director")
    public String removeDirector(@RequestParam("directorId") int directorId) {
        directorService.removeDirector(directorId);

        return "redirect:/admin_directors";
    }

    @RequestMapping(value = "/remove_genre")
    public String removeGenre(@RequestParam("genreId") int genreId) {
        genreService.removeGenre(genreId);

        return "redirect:/admin_genres";
    }

    @RequestMapping(value = "/remove_operator")
    public String removeOperator(@RequestParam("operatorId") int operatorId) {
        operatorService.removeOperator(operatorId);

        return "redirect:/admin_operators";
    }

    @RequestMapping(value = "edit_actor")
    public String editActor(@RequestParam("actorId") int actorId, Model model) {
        model.addAttribute("actor", actorService.getActorById(actorId));
        model.addAttribute("actors", actorService.getAllActors());

        return "admin_actors";
    }

    @RequestMapping(value = "edit_country")
    public String editCountry(@RequestParam("countryId") int countryId, Model model) {
        model.addAttribute("country", countryService.getCountryById(countryId));
        model.addAttribute("countries", countryService.getAllCountries());

        return "admin_countries";
    }

    @RequestMapping(value = "edit_director")
    public String editDirector(@RequestParam("directorId") int directorId, Model model) {
        model.addAttribute("director", directorService.getDirectorById(directorId));
        model.addAttribute("directors", directorService.getAllDirectors());

        return "admin_directors";
    }

    @RequestMapping(value = "edit_genre")
    public String editGenre(@RequestParam("genreId") int genreId, Model model) {
        model.addAttribute("genre", genreService.getGenreById(genreId));
        model.addAttribute("genres", genreService.getAllGenres());

        return "admin_genres";
    }

    @RequestMapping(value = "edit_operator")
    public String editOperator(@RequestParam("operatorId") int operatorId, Model model) {
        model.addAttribute("operator", operatorService.getOperatorById(operatorId));
        model.addAttribute("operators", operatorService.getAllOperators());

        return "admin_operators";
    }

    @GetMapping(value = "/film_form")
    public String addFilm(Model model) {

        model.addAttribute("film", new FilmForm());
        model.addAttribute("actors", actorService.getAllActors());
        model.addAttribute("directors", directorService.getAllDirectors());
        model.addAttribute("operators", operatorService.getAllOperators());
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("genres", genreService.getAllGenres());

        return "film_form";
    }

    @PostMapping(value = "/film_form")
    public String addFilm(@ModelAttribute("film") FilmForm filmForm, BindingResult bindingResult, Model model) {

        filmFormValidator.validate(filmForm, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("actors", actorService.getAllActors());
            model.addAttribute("directors", directorService.getAllDirectors());
            model.addAttribute("operators", operatorService.getAllOperators());
            model.addAttribute("countries", countryService.getAllCountries());
            model.addAttribute("genres", genreService.getAllGenres());

            return "film_form";
        }

        filmService.addFilm(filmForm);

        return "redirect:/film_form";
    }

    @RequestMapping(value = "/session_form", method = RequestMethod.GET)
    public String addSession(Model model) {
        model.addAttribute("session", new Session());
        model.addAttribute("films", filmService.getAllFilms());
        model.addAttribute("cinemaHalls", filmService.getAllCinemaHalls());

        return "session_form";
    }

    @RequestMapping(value = "/session_form", method = RequestMethod.POST)
    public String addSession(@ModelAttribute("session") Session session, BindingResult bindingResult, Model model) {
        sessionValidator.validate(session, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("films", filmService.getAllFilms());
            model.addAttribute("cinemaHalls", filmService.getAllCinemaHalls());

            return "session_form";
        }

        sessionService.addSession(session);

        return "redirect:/session_form";
    }

    @RequestMapping(value = "/actor_form", method = RequestMethod.GET)
    public String addActor(Model model) {
        model.addAttribute("actor", new Actor());

        return "actor_form";
    }

    @RequestMapping(value = "/actor_form", method = RequestMethod.POST)
    public String addActor(@ModelAttribute("actor") Actor actor, BindingResult bindingResult, Model model) {
        actorValidator.validate(actor, bindingResult);

        if (bindingResult.hasErrors()) {
            return "actor_form";
        }

        actorService.addActor(actor);

        return "redirect:/actor_form";
    }

    @RequestMapping(value = "/country_form", method = RequestMethod.GET)
    public String addCountry(Model model) {
        model.addAttribute("country", new Country());

        return "country_form";
    }

    @RequestMapping(value = "/country_form", method = RequestMethod.POST)
    public String addCountry(@ModelAttribute("country") Country country, BindingResult bindingResult, Model model) {
        countryValidator.validate(country, bindingResult);

        if (bindingResult.hasErrors()) {
            return "country_form";
        }

        countryService.addCountry(country);

        return "redirect:/country_form";
    }

    @RequestMapping(value = "/director_form", method = RequestMethod.GET)
    public String addDirector(Model model) {
        model.addAttribute("director", new Director());

        return "director_form";
    }

    @RequestMapping(value = "/director_form", method = RequestMethod.POST)
    public String addDirector(@ModelAttribute("director") Director director, BindingResult bindingResult, Model model) {
        directorValidator.validate(director, bindingResult);

        if (bindingResult.hasErrors()) {
            return "director_form";
        }

        directorService.addDirector(director);

        return "redirect:/director_form";
    }

    @RequestMapping(value = "/genre_form", method = RequestMethod.GET)
    public String addGenre(Model model) {
        model.addAttribute("genre", new Genre());

        return "genre_form";
    }

    @RequestMapping(value = "/genre_form", method = RequestMethod.POST)
    public String addGenre(@ModelAttribute("genre") Genre genre, BindingResult bindingResult, Model model) {
        genreValidator.validate(genre, bindingResult);

        if (bindingResult.hasErrors()) {
            return "genre_form";
        }

        genreService.addGenre(genre);

        return "redirect:/genre_form";
    }

    @RequestMapping(value = "/operator_form", method = RequestMethod.GET)
    public String addOperator(Model model) {
        model.addAttribute("operator", new Operator());

        return "operator_form";
    }

    @RequestMapping(value = "/operator_form", method = RequestMethod.POST)
    public String addOperator(@ModelAttribute("operator") Operator operator, BindingResult bindingResult, Model model) {
        operatorValidator.validate(operator, bindingResult);

        if (bindingResult.hasErrors()) {
            return "operator_form";
        }

        operatorService.addOperator(operator);

        return "redirect:/operator_form";
    }
}
