package com.hexaware.cm.service;

import com.hexaware.cm.exceptions.TrackingNumberNotFoundException;
import com.hexaware.cm.exceptions.InvalidEmployeeIdException;

public class CourierManagementService {

  
    public void transferAmount(String trackingNumber) throws TrackingNumberNotFoundException {
        if (trackingNumber == null || trackingNumber.isEmpty()) {
            throw new TrackingNumberNotFoundException("Tracking number not found!");
        }

        System.out.println("Transfer successful for tracking number: " + trackingNumber);
    }

  
    public void validateEmployeeId(int employeeId) throws InvalidEmployeeIdException {
    
        if (employeeId < 1000 || employeeId > 9999) {
            throw new InvalidEmployeeIdException("Invalid employee ID: " + employeeId);
        }
        System.out.println("Employee ID " + employeeId + " is valid.");
    }
}
