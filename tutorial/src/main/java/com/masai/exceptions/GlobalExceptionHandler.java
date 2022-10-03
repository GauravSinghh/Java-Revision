package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TutorialNotfoundException.class)
	public ResponseEntity<MyErrorDetails> tutorialNotFoundException(TutorialNotfoundException tnf ,WebRequest wr){
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), tnf.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception e ,WebRequest wr){
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException enf , WebRequest wr){
		MyErrorDetails err= new MyErrorDetails(LocalDateTime.now(), enf.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<MyErrorDetails> nullPointerExceptionHandler(NullPointerException enf , WebRequest wr){
		MyErrorDetails err= new MyErrorDetails(LocalDateTime.now(), enf.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}
