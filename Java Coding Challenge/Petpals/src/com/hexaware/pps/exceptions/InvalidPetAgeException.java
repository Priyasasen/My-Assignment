package com.hexaware.pps.exceptions;

public class InvalidPetAgeException extends Exception {
	
   
	private static final long serialVersionUID = 1L;

	public InvalidPetAgeException(String message) {
        super(message);
    }

}
