package by.psu.dao;

import by.psu.model.Cinema;

import java.util.List;

public interface CinemaDao extends CrudDao<Cinema> {

    List<Cinema> getAll();

    List<Cinema> getByCity(int cityId);

}
