package by.psu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.psu.model.*;
import by.psu.service.*;

@Component
public class CountryValidator implements Validator {

    @Autowired
    private CountryService countryService;

    @Override
    public boolean supports(Class<?> arg0) {
        return Country.class.equals(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Country country = (Country) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");

        if (countryService.getByName(country.getName()) != null) {
            errors.rejectValue("name", "Unique");
        }
    }
}
