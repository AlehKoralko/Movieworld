package by.psu.service;

import by.psu.model.Cinema;
import by.psu.model.City;

import java.util.List;

public interface CityService {

    void addCity(City city);

    City getCityById(int id);

    void updateCity(City city);

    void removeCity(int id);

    List<City> getAllCities();

    List<City> getCitiesByFilmSession(int filmId);

    List<Cinema> getCinemasByCity(int cityId);

}
