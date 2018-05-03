package by.psu.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

    @Transient
    private List<LocalDate> displayPeriod;

    @Transient
    private String formatDateStart;

    @Transient
    private String formatDateEnd;

    @Transient
    private String[] genresId;

    @Transient
    private String[] actorsId;

    @Transient
    private String[] directorsId;

    @Transient
    private String[] operatorsId;

    @Transient
    private String[] countriesId;

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

    public List<LocalDate> getDisplayPeriod() {
        return displayPeriod;
    }

    public void setDisplayPeriod(List<LocalDate> displayPeriod) {
        this.displayPeriod = displayPeriod;
    }

    public String getFormatDateStart() {
        return formatDateStart;
    }

    public void setFormatDateStart(String formatDateStart) {
        this.formatDateStart = formatDateStart;
    }

    public String getFormatDateEnd() {
        return formatDateEnd;
    }

    public void setFormatDateEnd(String formatDateEnd) {
        this.formatDateEnd = formatDateEnd;
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

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public String[] getActorsId() {
        return actorsId;
    }

    public void setActorsId(String[] actorsId) {
        this.actorsId = actorsId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", name=" + name + ", year=" + year + ", trailer=" + trailer + ", genresId="
                + genresId + ", directors=" + directors + ", actors=" + actors + ", countries="
                + countries + ", genres=" + genres + ", operators=" + operators + "]";
    }

}
