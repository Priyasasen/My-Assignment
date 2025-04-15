package com.hexaware.cm.entity;

import java.util.Scanner;

public class Task4 {
	

    public static void main(String[] args) {

        /* 9. Parcel Tracking: Create a program that allows users to input a parcel tracking number.Store the  
    	tracking number and Status in 2d String Array. Initialize the array with values. Then, simulate the 
    	tracking process by displaying messages like "Parcel in transit," "Parcel out for delivery," or "Parcel 
    	delivered" based on the tracking number's status.  */
    	
        String[][] trackingData = {
            {"TRK001", "Parcel in transit"},
            {"TRK002", "Parcel out for delivery"},
            {"TRK003", "Parcel delivered"},
            {"TRK004", "Parcel in transit"},
            {"TRK005", "Parcel delivered"}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parcel tracking number: ");
        String inputTrackingNumber = scanner.nextLine();

        boolean found = false;

        
        for (int i = 0; i < trackingData.length; i++) {
            if (trackingData[i][0].equalsIgnoreCase(inputTrackingNumber)) {
                System.out.println("Status: " + trackingData[i][1]);
                found = true;
                break;
            }
        }
        
       

        if (!found) {
            System.out.println("Tracking number not found.");
        }
        
       
        
        System.out.print("-------------------------------------");

   /*10. Customer Data Validation: Write a function which takes 2 parameters, data-denotes the data and 
detail-denotes if it is name address or phone number.Validate customer information based on 
following criteria. Ensure that names contain only letters and are properly capitalized, addresses do not 
contain special characters, and phone numbers follow a specific format (e.g., ###-###-####). */
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (name.length() > 0 && Character.isUpperCase(name.charAt(0)))
            System.out.println("Valid Name");
        else
            System.out.println("Invalid Name");

        System.out.print("Enter Phone (###-###-####): ");
        String phone = sc.nextLine();
        if (phone.length() == 12 && phone.charAt(3) == '-' && phone.charAt(7) == '-')
            System.out.println("Valid Phone");
        else
            System.out.println("Invalid Phone");

   // Task 11: Address Formatting
        System.out.print("Enter Street: ");
        String street = sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter State: ");
        String state = sc.nextLine();
        System.out.print("Enter Zip: ");
        String zip = sc.nextLine();

        System.out.println("Formatted Address:");
        System.out.println(cap(street) + ", " + cap(city) + ", " + cap(state) + " - " + zip);

        sc.close();
        scanner.close();
    }

   
    public static String cap(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
