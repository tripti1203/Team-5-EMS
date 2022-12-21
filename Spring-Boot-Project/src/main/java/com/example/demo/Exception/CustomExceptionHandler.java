package com.example.demo.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {
	
	public final ResponseEntity<ExceptionResponse> handleException(ResourceNotFoundException resourceNotFoundException, WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), resourceNotFoundException.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	public final ResponseEntity<ExceptionResponse> handleException(ResourceExistsException resourceExistsException, WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), resourceExistsException.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.CONFLICT);
	}

}
