package com.hexaware.cm.exceptions;

public class InvalidEmployeeIdException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public InvalidEmployeeIdException(String message) {
        super(message);
    }
}
