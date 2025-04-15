package com.hexaware.cm.exceptions;

public class CourierNotFoundException extends Exception {

   
	private static final long serialVersionUID = 1L;

	public CourierNotFoundException() {
        super("Courier not found.");
    }

    public CourierNotFoundException(String message) {
        super(message);
    }
}
