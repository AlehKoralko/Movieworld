package by.psu.dao;

import by.psu.model.Row;

import java.util.List;

public interface RowDao extends CrudDao<Row> {

    List<Row> getAll();

    List<Row> getRowsByCinemaHall(int cinemaHallId);

}
