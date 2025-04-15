package com.hexaware.cm.main;

import com.hexaware.cm.entity.Courier;
import com.hexaware.cm.dao.CourierUserServiceCollectionImpl;
import com.hexaware.cm.exceptions.*;
import com.hexaware.cm.service.CourierAdminServiceImpl;

public class MainApp {
    public static void main(String[] args) {

        // ---------- Task 7: admin Service (Inheritance + Exception Handling) ----------
    	try {
    	    CourierAdminServiceImpl adminService = new CourierAdminServiceImpl();

    	    int staffId = adminService.addCourierStaff("Rohan", "9876543210");
    	    System.out.println("Courier staff added successfully. ID = " + staffId);

    	
    	    String trackingNumber = "TRK0000";
    	    if (trackingNumber.equals("TRK0000")) {
    	        throw new TrackingNumberNotFoundException("Tracking number " + trackingNumber + " not found!");
    	    }

    	  
    	    int enteredId = 999;
    	    int actualId = 101;
    	    if (enteredId != actualId) {
    	        throw new InvalidEmployeeIdException("Employee ID " + enteredId + " is not valid!");
    	    }

    	} catch (TrackingNumberNotFoundException | InvalidEmployeeIdException e) {
    	    System.out.println("Exception caught: " + e.getMessage());
    	}


        // ---------- Task 8: User Service using Collections ----------
        CourierUserServiceCollectionImpl userService = new CourierUserServiceCollectionImpl();

        Courier courier1 = new Courier(1, "John", "Delhi", "Alice", "Mumbai", 2.5, "In Transit", "TRK1001", "2025-04-15", 101);
        Courier courier2 = new Courier(2, "Mike", "Pune", "Bob", "Chennai", 3.0, "Shipped", "TRK1002", "2025-04-16", 102);

        userService.addCourier(courier1);
        userService.addCourier(courier2);

        System.out.println("\nFinding courier with TRK1001...");
        Courier foundCourier = userService.findCourierByTrackingNumber("TRK1001");
        if (foundCourier != null) {
            System.out.println("Courier Found: " + foundCourier);
        } else {
            System.out.println("Courier Not Found");
        }

        System.out.println("\nListing All Couriers:");
        userService.listAllCouriers();
    }
}
