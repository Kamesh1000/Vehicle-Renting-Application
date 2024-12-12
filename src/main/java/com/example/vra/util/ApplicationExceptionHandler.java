package com.example.vra.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.vra.exception.ImageNotFoundException;
import com.example.vra.exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(UserNotFoundException exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),exception.getMessage(),"User Not found by id"));
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(ImageNotFoundException exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),exception.getMessage(),"Image Not found by id"));
	}
	
}
