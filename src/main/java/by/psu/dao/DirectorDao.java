package by.psu.dao;

import by.psu.model.Director;

import java.util.List;

public interface DirectorDao extends CrudDao<Director> {

    List<Director> getAllDirectors();

    Director getByName(String name);

}
