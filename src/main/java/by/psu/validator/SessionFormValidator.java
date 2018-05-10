package by.psu.validator;

import by.psu.dto.SessionForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class SessionFormValidator implements Validator {

    private DateTimeFormatter sessionDateformatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private DateTimeFormatter sessionTimeformatter = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public boolean supports(Class<?> aClass) {
        return SessionForm.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        SessionForm sessionForm = (SessionForm) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "time", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "filmId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cinemaHallId", "Required");

        if (! errors.hasFieldErrors("date")) {
            try {
                sessionDateformatter.parse(sessionForm.getDate(), LocalDate::from);
            } catch (Exception e) {
                errors.rejectValue("date", "Format.session.date");
            }
        }

        if (! errors.hasFieldErrors("time")) {
            try {
                sessionTimeformatter.parse(sessionForm.getTime(), LocalTime::from);
            } catch (Exception e) {
                errors.rejectValue("time", "Format.session.time");
            }
        }
    }
}
