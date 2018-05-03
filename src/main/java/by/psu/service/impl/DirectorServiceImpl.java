package by.psu.service.impl;

import by.psu.dao.DirectorDao;
import by.psu.model.Director;
import by.psu.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorDao directorDao;

    @Override
    @Transactional
    public void addDirector(Director director) {
        directorDao.add(director);
    }

    @Override
    @Transactional
    public Director getDirectorById(int id) {
        return directorDao.getById(id);
    }

    @Override
    @Transactional
    public void updateDirector(Director director) {
        directorDao.update(director);
    }

    @Override
    @Transactional
    public void removeDirector(int id) {
        directorDao.remove(id);
    }

    @Override
    @Transactional
    public List<Director> getAllDirectors() {
        return directorDao.getAllDirectors();
    }

    @Override
    @Transactional
    public Director getByName(String name) {
        return directorDao.getByName(name);
    }

}
