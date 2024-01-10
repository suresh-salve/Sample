package com.jbk.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jbk.model.CustomizeExceptionResponse;
//@RestControllerAdvice is an annotation in Spring Boot (and the broader Spring ecosystem) that allows you to define global
//exception handling for your Spring MVC controllers.
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap=new HashMap<>();
		List<FieldError> fieldErrors = ex.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			
			String field = fieldError.getField();
			String defaultMessage = fieldError.getDefaultMessage();
			errorMap.put(field, defaultMessage);
		}
		return errorMap;
		
	}
	//@ExceptionHandler is an annotation in the Spring Framework that is used to define a method that handles exceptions thrown by 
	//methods annotated with @RequestMapping or similar annotations.
	//When an exception occurs during the processing of a request, Spring Boot looks for a method annotated with @ExceptionHandler
	//within the same controller class (or a global handler if configured). This method is responsible for handling that specific type of
	//exception.
	@ExceptionHandler(ProductAlreadyExistException.class)
	@ResponseStatus(code=HttpStatus.CONFLICT)
	public CustomizeExceptionResponse productAlreadyExistException(ProductAlreadyExistException ex) {
		
		CustomizeExceptionResponse response=new CustomizeExceptionResponse();
		
		response.setDefaultMessage(ex.getMessage());
		response.setStatusCode(HttpStatus.CONFLICT.value());
		response.setDate(new Date());
		
		return response;
		
	}
	
	@ExceptionHandler(SomethingWentWrongException.class)
	
	public CustomizeExceptionResponse somethingWentWrongException(SomethingWentWrongException ex) {
		CustomizeExceptionResponse response=new CustomizeExceptionResponse();
		response.setDefaultMessage(ex.getMessage());
		response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setDate(new Date());
		return response;
		
	}
	
    @ExceptionHandler(ProductDoesNotFoundException.class)
	
	public CustomizeExceptionResponse productDoesNotFoundException(ProductDoesNotFoundException ex) {
		CustomizeExceptionResponse response=new CustomizeExceptionResponse();
		response.setDefaultMessage(ex.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setDate(new Date());
		return response;
		
	}
	
	
}
