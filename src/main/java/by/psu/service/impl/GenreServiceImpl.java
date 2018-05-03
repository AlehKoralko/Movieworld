package by.psu.service.impl;

import by.psu.dao.GenreDao;
import by.psu.model.Genre;
import by.psu.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override
    @Transactional
    public void addGenre(Genre genre) {
        genreDao.add(genre);
    }

    @Override
    @Transactional
    public Genre getGenreById(int id) {
        return genreDao.getById(id);
    }

    @Override
    @Transactional
    public void updateGenre(Genre genre) {
        genreDao.update(genre);
    }

    @Override
    @Transactional
    public void removeGenre(int id) {
        genreDao.remove(id);
    }

    @Override
    @Transactional
    public List<Genre> getAllGenres() {
        return genreDao.getAllGenres();
    }

    @Override
    @Transactional
    public Genre getByName(String name) {
        return genreDao.getByName(name);
    }

}
