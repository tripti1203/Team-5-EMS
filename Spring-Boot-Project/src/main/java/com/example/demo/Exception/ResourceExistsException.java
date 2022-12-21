package com.example.demo.Exception;

public class ResourceExistsException extends RuntimeException{
	public ResourceExistsException(String details) {
		super(details);
	}
}
