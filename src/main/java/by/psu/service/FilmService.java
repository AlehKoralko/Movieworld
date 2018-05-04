package by.psu.service;

import by.psu.dto.FilmForm;
import by.psu.model.CinemaHall;
import by.psu.model.Film;
import by.psu.model.Session;

import java.util.List;

public interface FilmService {

    void addFilm(FilmForm filmForm);

    Film getFilmById(int id);

    void updateFilm(Film film);

    void removeFilm(int id);

    List<Film> getAllFilms();

    List<Film> getFilmsByCity(int cityId);

    List<Session> getFilmsSessionsByCity(int filmId, int cityId);

    List<Session> getFilmsSessionsByCityAndDate(int filmId, int cityId, String date);

    List<Film> searchByName(String filmName);

    List<Film> searchByActor(String actorName);

    List<Film> searchByGenre(String genreName);

    List<Film> searchByCity(String cityName);

    List<Film> searchByDirector(String directorName);

    List<Film> searchByOperator(String operatorName);

    List<Film> searchByYear(String year);

    List<Film> searchByCountry(String countryName);

    List<Film> searchByDate(String date);

    List<CinemaHall> getAllCinemaHalls();

}
