package by.psu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.psu.model.*;
import by.psu.service.*;

@Component
public class ActorValidator implements Validator {

    @Autowired
    private ActorService actorService;

    @Override
    public boolean supports(Class<?> arg0) {
        return Actor.class.equals(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Actor actor = (Actor) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");

        if (actorService.getByName(actor.getName()) != null) {
            errors.rejectValue("name", "Unique");
        }
    }
}
