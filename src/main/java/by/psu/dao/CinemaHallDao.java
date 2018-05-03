package by.psu.dao;

import by.psu.model.CinemaHall;

import java.util.List;

public interface CinemaHallDao extends CrudDao<CinemaHall> {

    List<CinemaHall> getAll();

    List<CinemaHall> getCinemaHallsByCinema(int cinemaId);

}
