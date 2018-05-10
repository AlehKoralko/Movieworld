package by.psu.dto;

import by.psu.model.Session;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SessionForm implements Serializable {

    private int id;
    private String filmId;
    private String cinemaHallId;
    private String date;
    private String time;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public SessionForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(String cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Session toSession() {
        Session session = new Session();

        session.setDate(dateFormatter.parse(this.getDate(), LocalDate::from));
        session.setTime(timeFormatter.parse(this.getTime(), LocalTime::from));

        return session;
    }
}
