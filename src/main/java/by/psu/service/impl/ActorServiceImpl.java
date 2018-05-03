package by.psu.service.impl;

import by.psu.dao.ActorDao;
import by.psu.model.Actor;
import by.psu.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorDao actorDao;

    @Transactional
    public void addActor(Actor actor) {
        this.actorDao.add(actor);
    }

    @Transactional
    public Actor getActorById(int id) {
        return this.actorDao.getById(id);
    }

    @Transactional
    public void updateActor(Actor actor) {
        this.actorDao.update(actor);
    }

    @Transactional
    public void removeActor(int id) {
        this.actorDao.remove(id);
    }

    @Transactional
    public List<Actor> getAllActors() {
        return this.actorDao.getAll();
    }

    @Override
    @Transactional
    public Actor getByName(String name) {
        return actorDao.getByName(name);
    }
}
