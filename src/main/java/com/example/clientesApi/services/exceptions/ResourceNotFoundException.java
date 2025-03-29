package com.example.clientesApi.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super("Recurso não encontrado no id: " + id);
	}
	
	

}
