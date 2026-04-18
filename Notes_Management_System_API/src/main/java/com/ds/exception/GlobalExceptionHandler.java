package com.ds.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	//ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex){
		
		ErrorResponse error=new ErrorResponse(
				ex.getMessage(),
				404,LocalDateTime.now());
		
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//Validation Handler
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
		
		Map<String,String> errors= new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error-> {
			errors.put(error.getField(),error.getDefaultMessage());
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	//Generic Exception Handler
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex){
		
		ErrorResponse error =new ErrorResponse(
				ex.getMessage(),
				500,
				LocalDateTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
