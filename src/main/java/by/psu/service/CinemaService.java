package by.psu.service;

import by.psu.model.Cinema;

import java.util.List;

public interface CinemaService {

    void addCinema(Cinema cinema);

    Cinema getCinemaById(int id);

    void updateCinema(Cinema cinema);

    void removeCinema(int id);

    List<Cinema> getAllCinemas();

    List<Cinema> getByCityId(int cityId);

}
