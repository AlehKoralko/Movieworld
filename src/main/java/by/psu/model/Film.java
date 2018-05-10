package by.psu.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "about")
    private String about;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "film", fetch = FetchType.EAGER)
    private Set<Session> sessions;

    @ManyToMany
    @JoinTable(
            name = "film_has_director",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    @OrderBy("id asc")
    private Set<Director> directors;

    @ManyToMany
    @JoinTable(
            name = "film_has_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @OrderBy("id asc")
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(
            name = "film_has_country",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    @OrderBy("id asc")
    private Set<Country> countries;

    @ManyToMany
    @JoinTable(
            name = "film_has_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @OrderBy("id asc")
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "film_has_operator",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id")
    )
    @OrderBy("id asc")
    private Set<Operator> operators;

    public Film() {

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

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public Set<Operator> getOperators() {
        return operators;
    }

    public void setOperators(Set<Operator> operators) {
        this.operators = operators;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
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

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<LocalDate, String> getDisplayPeriod() {
        Map<LocalDate, String> dates = new TreeMap<>();

        for (int i = 0; i <= ChronoUnit.DAYS.between(this.getDateStart(), this.getDateEnd()); i++) {
            dates.put(this.getDateStart().plusDays(i),
                    this.getDateStart().plusDays(i).format(DateTimeFormatter.ofPattern("dd.MM")));
        }

        return dates;
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", name=" + name + ", year=" + year + ", trailer=" + trailer
                + ", directors=" + directors + ", actors=" + actors + ", countries="
                + countries + ", genres=" + genres + ", operators=" + operators + "]";
    }

}
