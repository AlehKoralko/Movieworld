package by.psu.dao;

import by.psu.model.Film;

import java.time.LocalDate;
import java.util.List;

public interface FilmDao extends CrudDao<Film> {

    List<Film> getAllFilms();

    List<Film> getFilmsByCity(int cityId);

    List<Film> searchByName(String filmName);

    List<Film> searchByActor(String actorName);

    List<Film> searchByGenre(String genreName);

    List<Film> searchByCity(String cityName);

    List<Film> searchByDirector(String directorName);

    List<Film> searchByOperator(String operatorName);

    List<Film> searchByYear(int year);

    List<Film> searchByCountry(String countryName);

    List<Film> searchByDate(LocalDate date);

}
