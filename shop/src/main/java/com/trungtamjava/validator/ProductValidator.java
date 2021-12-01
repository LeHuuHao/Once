package com.trungtamjava.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.trungtamjava.model.Product;
@Component
public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		///
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "input.required");

		if (product.getPassword() == null || product.getPassword().length() < 6 || product.getPassword().length() > 10) {
		    errors.rejectValue("password", "password.require");
		}

		if (product.getUsername() == null || product.getUsername().length() < 6 || product.getUsername().length() > 10) {
		    errors.rejectValue("username", "username.require");
		} else {
		    // check db co username nay chua
//		    User existingUser = userDao.getByUsername(user.getUsername());
//		    if (existingUser != null) {
//			errors.rejectValue("username", "username.existed");
//		    }
		}
		
	}

}
