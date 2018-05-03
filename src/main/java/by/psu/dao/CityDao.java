package by.psu.dao;

import by.psu.model.City;

import java.util.List;

public interface CityDao extends CrudDao<City> {

    List<City> getAll();

    List<City> getCitiesByFilmSession(int filmId);
}
