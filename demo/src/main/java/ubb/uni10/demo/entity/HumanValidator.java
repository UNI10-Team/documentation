package ubb.uni10.demo.entity;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class HumanValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Human.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Human human = (Human)target;
        if(human.getName().equals("")){
            errors.rejectValue("name", "name.empty");
        }
        if(human.getAge() < 0){
            errors.rejectValue("age", "age.negative");
        }
    }
}
