package com.example.question.validation;

import org.springframework.stereotype.Component;

@Component
public class InputValidationImpl implements InputValidator {

	@Override
	

	public boolean usernameValidator(String username) {
		return username.matches("[A-Za-z]{3,20}$");
	}
	


	
}


