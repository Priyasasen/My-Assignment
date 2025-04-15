package com.hexaware.cm.entity;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
//5. Write a Java program that uses a for loop to display all the orders for a specific customer.
        Scanner scanner = new Scanner(System.in);

     
        Courier[] orders = {
        	    new Courier(1, "Arun", "Chennai", "Raju", "Bengaluru", 2.5, "Shipped", "TRK001", "14-04-2025", 101),
        	    new Courier(2, "Divya", "Hyderabad", "Kiran", "Coimbatore", 3.0, "In Transit", "TRK002", "15-04-2025", 102),
        	    new Courier(3, "Priya", "Chennai", "Meena", "Madurai", 4.0, "Delivered", "TRK003", "13-04-2025", 101),
        	    new Courier(4, "Hari", "Kochi", "Lakshmi", "Tirupati", 1.2, "Pending", "TRK004", "16-04-2025", 103)
        	};


    
        System.out.print("Enter Customer ID to view orders: ");
        int customerId = scanner.nextInt();

        boolean found = false;

        for (Courier c : orders) {
            if (c.getUserId() == customerId) {
                System.out.println("Order Found: " + c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No orders found for this customer.");
        }

        System.out.println("--------------------------------------------------");


    
 // 6. Implement a while loop to track the real-time location of a courier until it reaches its destination.  
    
    System.out.print("Enter Courier ID to track: ");
    int courierId = scanner.nextInt();

    String location = "";

   
    while (true) {
        if (courierId == 101) {
            location = "On the way";
            break;  
        } else if (courierId == 102) {
            location = "Near Warehouse";
            break;  
        } else if (courierId == 103) {
            location = "Near Customer";
            break;  
        } else {
            location = "Courier ID not found.";
            break; 
        }
    }


    System.out.println("Courier " + courierId + " is currently: " + location);

    scanner.close();
}





}







