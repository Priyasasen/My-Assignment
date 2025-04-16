package com.hexaware.pps.exceptions;
import java.io.*;

public class ExceptionTest {

    public static void main(String[] args) {
       
        testInvalidPetAge();
        
        testNullPetProperty();
       
        testInsufficientFunds();
       
        testFileHandling();

        testAdoptionException();
    }

    private static void testInvalidPetAge() {
        try {
            int age = -5; 
            if (age <= 0) {
                throw new InvalidPetAgeException("Age must be a positive integer!");
            }
            System.out.println("Pet age accepted: " + age);
        } catch (InvalidPetAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    private static void testNullPetProperty() {
        try {
            String petName = null; 
            if (petName == null) {
                throw new NullPetPropertyException("Pet's name is missing!");
            }
        } catch (NullPetPropertyException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    private static void testInsufficientFunds() {
        try {
            double donationAmount = 5.00;
            if (donationAmount < 10.00) {
                throw new InsufficientFundsException("Donation amount must be at least $10!");
            }
            System.out.println("Donation accepted: $" + donationAmount);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    private static void testFileHandling() {
        try {
            File file = new File("pets.txt");
            if (!file.exists()) {
                throw new FileHandlingException("File not found!");
            }
        } catch (FileHandlingException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    private static void testAdoptionException() {
        try {
            boolean petAvailableForAdoption = false; 
            if (!petAvailableForAdoption) {
                throw new AdoptionException("Pet is not available for adoption!");
            }
        } catch (AdoptionException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
