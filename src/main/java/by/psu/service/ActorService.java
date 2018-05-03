package by.psu.service;

import by.psu.model.Actor;

import java.util.List;

public interface ActorService {

    void addActor(Actor actor);

    Actor getActorById(int id);

    void updateActor(Actor actor);

    void removeActor(int id);

    List<Actor> getAllActors();

    Actor getByName(String name);
}
