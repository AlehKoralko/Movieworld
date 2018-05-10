package by.psu.service.impl;

import by.psu.dao.SessionDao;
import by.psu.model.Session;
import by.psu.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private DateTimeFormatter formatDateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    @Autowired
    private SessionDao sessionDao;

    @Override
    @Transactional
    public void addSession(Session session) {
        sessionDao.add(session);
    }

    @Override
    @Transactional
    public Session getSessionById(int sessionId) {
        Session session = sessionDao.getById(sessionId);

        session.setFormatDate(session.getDate().format(formatDateFormatter));
        session.setFormatTime(session.getTime().format(timeFormatter));

        return session;
    }

    @Override
    @Transactional
    public void updateSession(Session session) {
        sessionDao.update(session);
    }

    @Override
    @Transactional
    public void removeSession(int sessionId) {
        sessionDao.remove(sessionId);
    }

    @Override
    @Transactional
    public List<Session> getAllSessions() {
        return sessionDao.getAll();
    }

    @Override
    @Transactional
    public int countFreePlaces(int sessionId) {
        return sessionDao.countFreePlaces(sessionId);
    }
}
