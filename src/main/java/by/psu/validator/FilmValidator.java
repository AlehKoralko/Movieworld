package by.psu.validator;

import by.psu.model.Film;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class FilmValidator implements Validator {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    @Override
    public boolean supports(Class<?> aClass) {
        return Film.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Film film = (Film) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tagline", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trailer", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "about", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formatDateStart", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formatDateEnd", "Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actorsId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "directorsId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "operatorsId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genresId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countriesId", "Required");

        if (film.getYear() < 1950 || film.getYear() > LocalDate.now().getYear() + 1) {
            errors.rejectValue("year", "Size.film.year");
        }

        try {
            film.setDateStart(formatter.parse(film.getFormatDateStart(), LocalDate::from));
        } catch (Exception e) {
            errors.rejectValue("formatDateStart", "Format.film.date");
        }


        try {
            film.setDateEnd(formatter.parse(film.getFormatDateEnd(), LocalDate::from));
        } catch (Exception e) {
            errors.rejectValue("formatDateEnd", "Format.film.date");
        }
    }
}
