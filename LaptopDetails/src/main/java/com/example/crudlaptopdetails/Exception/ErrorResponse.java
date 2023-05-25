package com.example.crudlaptopdetails.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ErrorResponse {
//
//	private int statusCode;
//	private String message;
//
//	public ErrorResponse(String message)
//	{
//		super();
//		this.message = message;
//	}
//
////Exception Handler method added in CustomerController to
////handle CustomerAlreadyExistsException exception
//@ExceptionHandler(value= LaptopaAlreadyExistsException.class)
//@ResponseStatus(HttpStatus.CONFLICT)
//public ErrorResponse
//handleLaptopAlreadyExistsException(
//	LaptopaAlreadyExistsException ex)
//{
//	return new ErrorResponse(ex.getMessage());//return new ErrorResponse(HttpStatus.CONFLICT.value(),ex.getMessage());
//}
//}
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ErrorResponse {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(LaptopaAlreadyExistsException.class)
	public String error(LaptopaAlreadyExistsException eh) {
		return eh.getLocalizedMessage();}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NoSuchLaptopExistsException.class)
	public String error(NoSuchLaptopExistsException eh) 
	{return "ERROR : " + eh.getMessage();}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidation(MethodArgumentNotValidException exception)
	{
		HashMap<String, String> errors = new HashMap<>();
	exception.getBindingResult().getAllErrors().forEach((error) -> {String fieldName = ((FieldError) error).getField();
	String errorMessage = error.getDefaultMessage();errors.put(fieldName, errorMessage);});
	return errors;
	}
}


