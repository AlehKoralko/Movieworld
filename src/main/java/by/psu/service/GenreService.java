package by.psu.service;

import by.psu.model.Genre;

import java.util.List;

public interface GenreService {

    void addGenre(Genre genre);

    Genre getGenreById(int id);

    void updateGenre(Genre genre);

    void removeGenre(int id);

    List<Genre> getAllGenres();

    Genre getByName(String name);
}
