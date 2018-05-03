package by.psu.dao;

import by.psu.model.Genre;

import java.util.List;

public interface GenreDao extends CrudDao<Genre> {

    List<Genre> getAllGenres();

    Genre getByName(String name);

}
