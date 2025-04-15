package com.hexaware.cm.entity;

import java.util.Scanner;

public class Task1 {
	
	public static void main(String[] args) {
		
		//1.Checking order Status
		
		String status = "delivered";
		
		if (status.equalsIgnoreCase("Delivered")) {
			
			System.out.println("The order has been Delivered.");
		}
		
		else if(status.equalsIgnoreCase("Processing")) {
			System.out.println("The order is being processed.");
			 
		}
		
		else if (status.equalsIgnoreCase("Cancelled")) {
         System.out.println("The order has been cancelled.");
         
		} 
		else {
         System.out.println("Unknown status.");
		
		}
		
		System.out.println("-----------------------------------");
	
	    //2.Parcel weight Categorization
		
		double weight = 5;
		String category;
		
		if (weight < 2.0) {
			
			category = "Light";	
		}else if (weight < 5.0) {
            category = "Medium";
        } else {
            category = "Heavy";
        }

        switch (category) {
            case "Light":
                System.out.println("This is a Light parcel.");
                break;
            case "Medium":
                System.out.println("This is a Medium parcel.");
                break;
            case "Heavy":
                System.out.println("This is a Heavy parcel.");
                break;
            default:
                System.out.println("Unknown weight category.");
        }
        
        System.out.println("-----------------------------------");
        
        //3.User Authentication
        
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Login into Customer or Employee");
        System.out.print("Enter 1 for Customer or 2 for Employee: ");
        int roleChoice = scanner.nextInt(); 
        scanner.nextLine();

      
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        
        if (email.isEmpty() || password.isEmpty()) {
            System.out.println("Email or password cannot be empty!");
        } else {
           
            if (roleChoice == 1) {  
                if (email.contains("@") && password.length() > 4) {
                    System.out.println("Customer login successful!");
                } else {
                    System.out.println("Invalid customer email or password.");
                }
            } else if (roleChoice == 2) {  
                if (email.contains("@") && password.length() > 4) {
                    System.out.println("Employee login successful!");
                } else {
                    System.out.println("Invalid employee email or password.");
                }
            } else {
                System.out.println("Invalid role selected! Please select 1 for Customer or 2 for Employee.");
            }
            
        }

        
          
        System.out.println("-----------------------------------");
    
	
	 

     /* 4. Implement Courier Assignment Logic 1. Develop a mechanism to assign couriers to shipments based 
        on predefined criteria (e.g., proximity, load capacity) using loops. */
        Courier[] orders = {
        	    new Courier(1, "Arun", "Chennai", "Raju", "Bengaluru", 2.5, "Shipped", "TRK001", "14-04-2025", 101),
        	    new Courier(2, "Divya", "Hyderabad", "Kiran", "Coimbatore", 3.0, "In Transit", "TRK002", "15-04-2025", 102),
        	    new Courier(3, "Arun", "Chennai", "Meena", "Madurai", 4.0, "Delivered", "TRK003", "13-04-2025", 101),
        	    new Courier(4, "Hari", "Kochi", "Lakshmi", "Tirupati", 1.2, "Pending", "TRK004", "16-04-2025", 103)
        	};


        	System.out.print("Enter maximum weight you can accept: ");
        	double maxWeight = scanner.nextDouble();

        	boolean assigned = false;

        	for (Courier c : orders) {
        	    if (c.getWeight() <= maxWeight) {
        	        System.out.println("Assigned Courier: " + c);
        	        assigned = true;
        	        break;
        	    }
        	}

        	if (!assigned) {
        	    System.out.println("No courier available under the given weight.");
        	}
        	
        	scanner.close();

	
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	


