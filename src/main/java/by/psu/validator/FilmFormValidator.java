package by.psu.validator;

import by.psu.dto.FilmForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class FilmFormValidator implements Validator {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    @Override
    public boolean supports(Class<?> aClass) {
        return FilmForm.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        FilmForm filmForm = (FilmForm) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tagline", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trailer", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "about", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateStart", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateEnd", "Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actorsId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "directorsId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "operatorsId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genresId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countriesId", "Required");

        if (! errors.hasFieldErrors("year")) {
            if (filmForm.getYear() < 1950 || filmForm.getYear() > LocalDate.now().getYear() + 1) {
                errors.rejectValue("year", "Size.film.year");
            }
        }

        if (! errors.hasFieldErrors("dateStart")) {
            try {
                formatter.parse(filmForm.getDateStart(), LocalDate::from);
            } catch (Exception e) {
                errors.rejectValue("dateStart", "Format.film.date");
            }
        }


        if (! errors.hasFieldErrors("dateEnd"))
        try {
            formatter.parse(filmForm.getDateEnd(), LocalDate::from);
        } catch (Exception e) {
            errors.rejectValue("dateEnd", "Format.film.date");
        }
    }
}
