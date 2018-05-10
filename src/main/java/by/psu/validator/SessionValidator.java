package by.psu.validator;

import by.psu.model.Session;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class SessionValidator implements Validator {

    private DateTimeFormatter sessionDateformatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private DateTimeFormatter sessionTimeformatter = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public boolean supports(Class<?> aClass) {
        return Session.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Session session = (Session) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formatDate", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formatTime", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "filmId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cinemaHallId", "Required");

        if (! errors.hasFieldErrors("formatDate")) {
            try {
                sessionDateformatter.parse(session.getFormatDate(), LocalDate::from);
            } catch (Exception e) {
                errors.rejectValue("formatDate", "Format.session.date");
            }
        }

        if (! errors.hasFieldErrors("formatTime")) {
            try {
                sessionTimeformatter.parse(session.getFormatTime(), LocalTime::from);
            } catch (Exception e) {
                errors.rejectValue("formatTime", "Format.session.time");
            }
        }
    }
}
