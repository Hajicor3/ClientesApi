package com.example.clientesApi.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.clientesApi.services.exceptions.ResourceNotFoundException;
import com.example.clientesApi.services.exceptions.feignexceptions.FeignExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError  erro = new StandardError(Instant.now(),status.value(),error,request.getRequestURI(),e.getMessage());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> illegalArgument(IllegalArgumentException e, HttpServletRequest request) {
		String error = "Request inválido!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError  erro = new StandardError(Instant.now(),status.value(),error,request.getRequestURI(),e.getMessage());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(FeignExceptionHandler.class)
	public ResponseEntity<StandardError> feignClientExceptionHandler(FeignExceptionHandler e, HttpServletRequest request) {
		String error = "Falha na comunicação com o microserviço!";
		HttpStatus status = HttpStatus.valueOf(e.getStatusCode());
		StandardError  erro = new StandardError(Instant.now(),status.value(),error,request.getRequestURI(),e.getMessage());
		return ResponseEntity.status(status).body(erro);
	}
}
