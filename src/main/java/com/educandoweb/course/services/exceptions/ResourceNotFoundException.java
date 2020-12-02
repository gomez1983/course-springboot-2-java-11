package com.educandoweb.course.services.exceptions;

// Essa classe é uma subclasse do RuntimeExeption, que é uma exceção que o compilador não te obriga a tratar
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}

}