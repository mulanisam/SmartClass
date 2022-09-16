package com.app.exceptionHandler;

import java.time.LocalDateTime;

import com.app.customExceptionHandler.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleCustomException(ResourceNotFoundException e) {
		ApiResponse resp = new ApiResponse(LocalDateTime.now(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleExistingUserExcetpion(DataIntegrityViolationException e) {
		ApiResponse resp = new ApiResponse(LocalDateTime.now(), "User already exisited with this Email!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("in handle invalid meth args ");
	//	System.out.println(ex.getBindingResult().getFieldErrors());
		StringBuilder sb = new StringBuilder("Validation Errors : ");
		ex.getBindingResult().getFieldErrors().forEach(e -> sb.append(e.getDefaultMessage()+" "));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(LocalDateTime.now(), sb.toString()));
	}
}
