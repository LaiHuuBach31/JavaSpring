package com.project.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dao.ProductDAO;

public class UniqueValidatorProduct implements ConstraintValidator<Unique, String>{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
    public void initialize(Unique constraintAnnotation) {
        
    }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && !productDAO.existsByUsername(value);
	}

}
