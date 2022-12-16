package com.gabby.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(ProductException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(ProductException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(AddressException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(AdminException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminSessionException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(AdminSessionException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(CartException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(CustomerException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerSessionException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(CustomerSessionException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(LoginException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LogoutException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(LogoutException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(OrderException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<CustomizeError> exceptionHandler(UserException bnf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<CustomizeError> notFoundUri(NoHandlerFoundException nhf, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), nhf.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomizeError> anyGenericException(Exception e, WebRequest req){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomizeError> validationErr(MethodArgumentNotValidException me){
		
		CustomizeError customizeErr= new CustomizeError(LocalDateTime.now(), "Validation Error", me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<CustomizeError>(customizeErr, HttpStatus.BAD_REQUEST);

	}
	
}
