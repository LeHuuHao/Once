package com.trungtamjava.hellospringboot.validator;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.trungtamjava.hellospringboot.entity.Product;
@Component
public class ProductValidator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "input.require");

		if (product.getDescription() == null|| product.getDescription().length() < 6 ) {
		    errors.rejectValue("description", "description.require");
		}

		if (product.getName() ==null) {
		    errors.rejectValue("name", "name.require");
		}
		
	}

}
