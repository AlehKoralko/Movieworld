package by.psu.service.impl;

import by.psu.dao.CinemaDao;
import by.psu.dao.CityDao;
import by.psu.model.Cinema;
import by.psu.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDao cinemaDao;

    @Autowired
    private CityDao cityDao;

    @Transactional
    public void addCinema(Cinema cinema) {
        this.cinemaDao.add(cinema);
    }

    @Transactional
    public Cinema getCinemaById(int id) {
        return this.cinemaDao.getById(id);
    }

    @Transactional
    public void updateCinema(Cinema cinema) {
        this.cinemaDao.update(cinema);
    }

    @Transactional
    public void removeCinema(int id) {
        this.cinemaDao.remove(id);
    }

    @Transactional
    public List<Cinema> getAllCinemas() {
        return this.cinemaDao.getAll();
    }

    @Transactional
    public List<Cinema> getByCityId(int cityId) {
        return (List<Cinema>) this.cinemaDao.getByCity(cityId);
    }
}
