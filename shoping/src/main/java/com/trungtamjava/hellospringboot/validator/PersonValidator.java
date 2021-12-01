package com.trungtamjava.hellospringboot.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.trungtamjava.hellospringboot.entity.Person;

@Component
public class PersonValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person user = (Person) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "input.require");

		if (user.getPassword() == null || user.getPassword().length() < 6) {
		    errors.rejectValue("password", "password.require");
		}

		if (user.getUsername() == null || user.getUsername().length() < 6 || user.getUsername().length() > 10) {
		    errors.rejectValue("username", "username.require");
		}
		
	}


}
