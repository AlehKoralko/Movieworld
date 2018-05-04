package by.psu.dto;

import by.psu.model.Film;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FilmForm implements Serializable {

    private int id;
    private String name;
    private int year;
    private String tagline;
    private String trailer;
    private String about;
    private double price;

    private List<String> displayPeriod;
    private String dateStart;
    private String dateEnd;

    private String[] actorsId;
    private String[] genresId;
    private String[] directorsId;
    private String[] operatorsId;
    private String[] countriesId;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public FilmForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getDisplayPeriod() {
        return displayPeriod;
    }

    public void setDisplayPeriod(List<String> displayPeriod) {
        this.displayPeriod = displayPeriod;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String[] getActorsId() {
        return actorsId;
    }

    public void setActorsId(String[] actorsId) {
        this.actorsId = actorsId;
    }

    public String[] getGenresId() {
        return genresId;
    }

    public void setGenresId(String[] genresId) {
        this.genresId = genresId;
    }

    public String[] getDirectorsId() {
        return directorsId;
    }

    public void setDirectorsId(String[] directorsId) {
        this.directorsId = directorsId;
    }

    public String[] getOperatorsId() {
        return operatorsId;
    }

    public void setOperatorsId(String[] operatorsId) {
        this.operatorsId = operatorsId;
    }

    public String[] getCountriesId() {
        return countriesId;
    }

    public void setCountriesId(String[] countriesId) {
        this.countriesId = countriesId;
    }

    public Film toFilm() {
        Film film = new Film();

        film.setName(this.getName());
        film.setYear(this.getYear());
        film.setAbout(this.getAbout());
        film.setTagline(this.getTagline());
        film.setTrailer(this.getTrailer());
        film.setPrice(this.getPrice());

        film.setDateStart(parseStringToLocalDate(this.getDateStart()));
        film.setDateEnd(parseStringToLocalDate(this.getDateEnd()));

        return film;
    }

    private LocalDate parseStringToLocalDate(String stringDate) {
        return dateFormatter.parse(stringDate, LocalDate::from);
    }
}
