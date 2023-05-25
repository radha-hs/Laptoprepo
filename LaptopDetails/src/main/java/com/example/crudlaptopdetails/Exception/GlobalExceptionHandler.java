//package com.example.crudlaptopdetails.Exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice
//	public class GlobalExceptionHandler {
//
//		@ExceptionHandler(value= NoSuchLaptopExistsException.class)
//		@ResponseStatus(HttpStatus.BAD_REQUEST)
//		public @ResponseBody ErrorResponse
//		handleException(NoSuchLaptopExistsException ex)
//		{
//			return new ErrorResponse(ex.getMessage());//return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
//		}
//	}
// //dafault exception    
//
