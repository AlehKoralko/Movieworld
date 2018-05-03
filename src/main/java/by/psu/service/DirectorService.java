package by.psu.service;

import by.psu.model.Director;

import java.util.List;

public interface DirectorService {

    void addDirector(Director director);

    Director getDirectorById(int id);

    void updateDirector(Director director);

    void removeDirector(int id);

    List<Director> getAllDirectors();

    Director getByName(String name);

}
