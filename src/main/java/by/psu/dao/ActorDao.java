package by.psu.dao;

import by.psu.model.Actor;

import java.util.List;

public interface ActorDao extends CrudDao<Actor> {

    List<Actor> getAll();

    Actor getByName(String name);
}
