package by.psu.service.impl;

import by.psu.dao.CinemaDao;
import by.psu.dao.CityDao;
import by.psu.model.Cinema;
import by.psu.model.City;
import by.psu.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CinemaDao cinemaDao;

    @Override
    @Transactional
    public void addCity(City city) {
        this.cityDao.add(city);
    }

    @Override
    @Transactional
    public City getCityById(int id) {
        return this.cityDao.getById(id);
    }

    @Override
    @Transactional
    public void updateCity(City city) {
        this.cityDao.update(city);
    }

    @Transactional
    public void removeCity(int id) {
        this.cityDao.remove(id);
    }

    @Override
    @Transactional
    public List<City> getAllCities() {
        return this.cityDao.getAll();
    }

    @Override
    @Transactional
    public List<City> getCitiesByFilmSession(int filmId) {
        return this.cityDao.getCitiesByFilmSession(filmId);
    }

    @Override
    @Transactional
    public List<Cinema> getCinemasByCity(int cityId) {
        return this.cinemaDao.getByCity(cityId);
    }

}
