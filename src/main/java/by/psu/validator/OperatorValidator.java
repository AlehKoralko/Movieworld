package by.psu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.psu.model.*;
import by.psu.service.*;

@Component
public class OperatorValidator implements Validator {

    @Autowired
    private OperatorService operatorService;

    @Override
    public boolean supports(Class<?> arg0) {
        return Operator.class.equals(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Operator operator = (Operator) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");

        if (! errors.hasFieldErrors("name")) {
            if (operatorService.getByName(operator.getName()) != null) {
                errors.rejectValue("name", "Unique");
            }
        }
    }
}
