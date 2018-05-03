package by.psu.service.impl;

import by.psu.dao.CinemaHallDao;
import by.psu.dao.FilmDao;
import by.psu.dao.SessionDao;
import by.psu.model.Session;
import by.psu.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private DateTimeFormatter formatDateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private FilmDao filmDao;

    @Autowired
    private CinemaHallDao cinemaHallDao;

    @Override
    @Transactional
    public void addSession(Session session) {
        session.setDate(dateFormatter.parse(session.getFormatDate(), LocalDate::from));
        session.setTime(timeFormatter.parse(session.getFormatTime(), LocalTime::from));

        session.setFilm(filmDao.getById(Integer.valueOf(session.getFilmId())));
        session.setCinemaHall(cinemaHallDao.getById(Integer.valueOf(session.getCinemaHallId())));

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
