package com.project.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dao.CategoryDAO;

public class UniqueValidatorCategory implements ConstraintValidator<Unique, String> {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
    public void initialize(Unique constraintAnnotation) {
        
    }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && !categoryDAO.existsByUsername(value);
	}

}
