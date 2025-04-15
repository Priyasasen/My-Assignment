package com.hexaware.cm.entity;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        //  7: Tracking history based on courier ID
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Courier ID to track: ");
        int courierId = scanner.nextInt();

        if (courierId == 1) {
            System.out.println("Tracking history for Courier 1: Picked up -> On the way -> Near Central Hub -> Delivered");
        } else if (courierId == 2 ) {
            System.out.println("Tracking history for Courier 2: Picked up -> In transit -> Near Warehouse -> Delivered");
        } else if (courierId == 3 ) {
            System.out.println("Tracking history for Courier 2: Picked up -> In transit -> Near Warehouse -> Delivered");
        }
        else {
            System.out.println("Invalid Courier ID.");
        }

        //  8: Nearest available courier based on weight
        double[] weights = {3.5, 2.0, 4.1};
        int nearestId = 1;
        double nearestWeight = weights[0];

        for (int i = 1; i < weights.length; i++) {
            if (weights[i] < nearestWeight) {
                nearestWeight = weights[i];
                nearestId = i + 1;  
            }
        }

        System.out.println("\nNearest available courier: ID " + nearestId + ", Weight: " + nearestWeight);

        scanner.close();
    }
}
