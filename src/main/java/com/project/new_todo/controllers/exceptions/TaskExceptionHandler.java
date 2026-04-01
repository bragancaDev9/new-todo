package com.project.new_todo.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.new_todo.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TaskExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		
		StandardError standardError = new StandardError(
				System.currentTimeMillis(), 
				httpStatus.value(), 
				"Object not found.", 
				objectNotFoundException.getMessage(), 
				httpServletRequest.getRequestURI()
		);
		
		return ResponseEntity.status(httpStatus).body(standardError);
	}
}
