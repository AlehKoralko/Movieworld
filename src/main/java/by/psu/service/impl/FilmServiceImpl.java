package by.psu.service.impl;

import by.psu.dao.*;
import by.psu.model.*;
import by.psu.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDao filmDao;

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private ActorDao actorDao;

    @Autowired
    private DirectorDao directorDao;

    @Autowired
    private OperatorDao operatorDao;

    @Autowired
    private CountryDao countryDao;

    @Autowired
    private CinemaHallDao cinemaHallDao;

    private DateTimeFormatter sessionDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter filmDateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private DateTimeFormatter searchDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    @Transactional
    public void addFilm(Film film) {
        film.setDateStart(filmDateFormatter.parse(film.getFormatDateStart(), LocalDate::from));
        film.setDateEnd(filmDateFormatter.parse(film.getFormatDateEnd(), LocalDate::from));

        Set<Actor> actors = new HashSet<>();
        Set<Director> directors = new HashSet<>();
        Set<Genre> genres = new HashSet<>();
        Set<Operator> operators = new HashSet<>();
        Set<Country> countries = new HashSet<>();

        Arrays.stream(film.getActorsId()).forEach(id -> actors.add(actorDao.getById(Integer.valueOf(id))));
        Arrays.stream(film.getDirectorsId()).forEach(id -> directors.add(directorDao.getById(Integer.valueOf(id))));
        Arrays.stream(film.getGenresId()).forEach(id -> genres.add(genreDao.getById(Integer.valueOf(id))));
        Arrays.stream(film.getOperatorsId()).forEach(id -> operators.add(operatorDao.getById(Integer.valueOf(id))));
        Arrays.stream(film.getCountriesId()).forEach(id -> countries.add(countryDao.getById(Integer.valueOf(id))));

        film.setActors(actors);
        film.setDirectors(directors);
        film.setGenres(genres);
        film.setOperators(operators);
        film.setCountries(countries);

        this.filmDao.add(film);
    }

    @Override
    @Transactional
    public Film getFilmById(int id) {
        Film film = this.filmDao.getById(id);
        List<LocalDate> dates = new ArrayList<>();

        for (int i = 0; i <= ChronoUnit.DAYS.between(film.getDateStart(), film.getDateEnd()); i++) {
            dates.add(film.getDateStart().plusDays(i));
        }

        film.setDisplayPeriod(dates);
        film.setFormatDateStart(film.getDateStart().format(DateTimeFormatter.ofPattern("dd.MM")));
        film.setFormatDateEnd(film.getDateEnd().format(DateTimeFormatter.ofPattern("dd.MM")));

        return film;
    }

    @Override
    @Transactional
    public void updateFilm(Film film) {
        this.filmDao.update(film);
    }

    @Override
    @Transactional
    public void removeFilm(int id) {
        this.filmDao.remove(id);
    }

    @Override
    @Transactional
    public List<Film> getAllFilms() {
        return this.filmDao.getAllFilms();
    }

    @Override
    @Transactional
    public List<Session> getFilmsSessionsByCity(int filmId, int cityId) {
        List<Session> sessions = this.sessionDao.getFilmSessionsBycity(filmId, cityId);

        for (Session session : sessions) {
            session.setFormatDate(session.getDate().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
            session.setFormatTime(session.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));
            session.setFreePlaces(sessionDao.countFreePlaces(session.getId()));
        }

        return sessions;
    }

    @Override
    @Transactional
    public List<Session> getFilmsSessionsByCityAndDate(int filmId, int cityId, String date) {
        LocalDate formatDate = sessionDateFormatter.parse(date, LocalDate::from);

        List<Session> sessions = this.sessionDao.getFilmsSessionsByCityAndDate(filmId, cityId, formatDate);

        for (Session session : sessions) {
            session.setFormatDate(session.getDate().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
            session.setFormatTime(session.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));
            session.setFreePlaces(sessionDao.countFreePlaces(session.getId()));
        }

        return sessions;
    }

    @Override
    @Transactional
    public List<Film> getFilmsByCity(int cityId) {
        return this.filmDao.getFilmsByCity(cityId);
    }

    @Override
    @Transactional
    public List<Film> searchByName(String filmName) {
        return filmDao.searchByName(filmName);
    }

    @Override
    @Transactional
    public List<Film> searchByActor(String actorName) {
        return filmDao.searchByActor(actorName);
    }

    @Override
    @Transactional
    public List<Film> searchByGenre(String genreName) {
        return filmDao.searchByGenre(genreName);
    }

    @Override
    @Transactional
    public List<Film> searchByCity(String cityName) {
        return filmDao.searchByCity(cityName);
    }

    @Override
    @Transactional
    public List<Film> searchByDirector(String directorName) {
        return filmDao.searchByDirector(directorName);
    }

    @Override
    @Transactional
    public List<Film> searchByOperator(String operatorName) {
        return filmDao.searchByOperator(operatorName);
    }

    @Override
    @Transactional
    public List<Film> searchByYear(String year) {
        try {
            return filmDao.searchByYear(Integer.valueOf(year));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public List<Film> searchByCountry(String countryName) {
        return filmDao.searchByCountry(countryName);
    }

    @Override
    @Transactional
    public List<Film> searchByDate(String date) {
        try {
            return filmDao.searchByDate(searchDateFormatter.parse(date, LocalDate::from));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public List<CinemaHall> getAllCinemaHalls() {
        return cinemaHallDao.getAll();
    }

}
