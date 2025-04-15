package com.hexaware.cm.entity;

import java.util.*;

public class Task4Continuation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 12: Order Confirmation Email
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter order number: ");
        String orderNumber = sc.nextLine();
        System.out.print("Enter delivery address: ");
        String address = sc.nextLine();
        System.out.print("Enter expected delivery date (dd-MM-yyyy): ");
        String deliveryDate = sc.nextLine();

        System.out.println("Order Confirmation Email:\nName: " + name + "\nOrder: " + orderNumber + "\nAddress: " + address + "\nDelivery Date: " + deliveryDate);

        System.out.println("------Calculating Shipping Costs------------");

        //13: Calculate Shipping Costs
        System.out.print("Enter source address: ");
        String source = sc.nextLine();
        System.out.print("Enter destination address: ");
        String destination = sc.nextLine();
        System.out.print("Enter distance (km): ");
        double distance = sc.nextDouble();
        System.out.print("Enter weight (kg): ");
        double weight = sc.nextDouble();
        
        double shippingCost = distance * weight * 0.5;
        System.out.println("Shipping cost from " + source + " to " + destination + ": ₹" + shippingCost);
        System.out.println("------Password Generation------------");
        //14: Password Generator
        System.out.println("Generated password: " + generatePassword());
        System.out.println("------Similar address------------");
       
        //15: Find Similar Addresses
        sc.nextLine(); 
        System.out.print("Enter address to find similar: ");
        String addressToFind = sc.nextLine();

        if (address.contains(addressToFind)) {
            System.out.println("Similar address found.");
        } else {
            System.out.println("No similar address found.");
        }

        sc.close();
    }

   
    public static String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuilder password = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            password.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return password.toString();
    }
}
