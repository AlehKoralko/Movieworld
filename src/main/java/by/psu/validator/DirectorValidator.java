package by.psu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.psu.model.*;
import by.psu.service.*;

@Component
public class DirectorValidator implements Validator {

    @Autowired
    private DirectorService directorService;

    @Override
    public boolean supports(Class<?> arg0) {
        return Director.class.equals(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Director director = (Director) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");

        if (! errors.hasFieldErrors("name")) {
            if (directorService.getByName(director.getName()) != null) {
                errors.rejectValue("name", "Unique");
            }
        }
    }
}
