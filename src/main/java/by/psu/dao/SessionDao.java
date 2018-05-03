package by.psu.dao;

import by.psu.model.Session;

import java.time.LocalDate;
import java.util.List;

public interface SessionDao extends CrudDao<Session> {

    List<Session> getAll();

    List<Session> getFilmSessionsBycity(int filmId, int cityId);

    List<Session> getFilmsSessionsByCityAndDate(int filmId, int cityId, LocalDate date);

    int countFreePlaces(int sessionId);

}
