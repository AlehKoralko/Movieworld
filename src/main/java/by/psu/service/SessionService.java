package by.psu.service;

import by.psu.model.Session;

import java.util.List;

public interface SessionService {

    void addSession(Session session);

    Session getSessionById(int sessionId);

    void updateSession(Session session);

    void removeSession(int sessionId);

    List<Session> getAllSessions();

    int countFreePlaces(int sessionId);

}
