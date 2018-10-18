package ua.logos.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.logos.repository.ModelRepository;

@Component
public class CheckModelExistsValidator implements ConstraintValidator<CheckModelExists, String>{

	@Autowired private ModelRepository modelRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(modelRepository.findByName(value) == null) {
			return true;
		}
		return false;
	}

}
