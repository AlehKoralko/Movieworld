package by.psu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.psu.model.*;
import by.psu.service.*;

@Component
public class GenreValidator implements Validator {

    @Autowired
    private GenreService genreService;

    @Override
    public boolean supports(Class<?> arg0) {
        return Genre.class.equals(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Genre genre = (Genre) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");

        if (genreService.getByName(genre.getName()) != null) {
            errors.rejectValue("name", "Unique");
        }
    }
}
