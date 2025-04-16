package com.hexaware.pps.presentation;

import java.sql.*;
import java.util.Scanner;
import com.hexaware.pps.util.DBConnection;

public class PetPalsDBApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    displayPetListings();
                    break;
                case 2:
                    recordDonation();
                    break;
                case 3:
                    manageAdoptionEvents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- PetPals Database Application ---");
        System.out.println("1. Display Pet Listings");
        System.out.println("2. Record Donation");
        System.out.println("3. Manage Adoption Events");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayPetListings() {
        try (Connection connection = DBConnection.getDBConnection()) {
            String sql = "SELECT * FROM Pets WHERE AvailableForAdoption = 1";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- Available Pets for Adoption ---");
            while (rs.next()) {
                int petID = rs.getInt("PetID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String breed = rs.getString("Breed");
                String type = rs.getString("Type");
                System.out.println("Pet ID: " + petID + ", Name: " + name + ", Age: " + age + ", Breed: " + breed + ", Type: " + type);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching pet listings: " + e.getMessage());
        }
    }

    private static void recordDonation() {
        System.out.print("Enter Donor Name: ");
        String donorName = scanner.nextLine();
        System.out.print("Enter Donation Type (Cash/Item): ");
        String donationType = scanner.nextLine();
        Double donationAmount = null;
        String donationItem = null;

        if (donationType.equalsIgnoreCase("Cash")) {
            System.out.print("Enter Donation Amount: ");
            donationAmount = scanner.nextDouble();
        } else if (donationType.equalsIgnoreCase("Item")) {
            System.out.print("Enter Donation Item: ");
            donationItem = scanner.nextLine();
        }

        try (Connection connection = DBConnection.getDBConnection()) {
            String sql = "INSERT INTO Donations (DonorName, DonationType, DonationAmount, DonationItem, DonationDate) VALUES (?, ?, ?, ?, NOW())";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, donorName);
            pstmt.setString(2, donationType);
            pstmt.setObject(3, donationAmount);
            pstmt.setObject(4, donationItem);
            pstmt.executeUpdate();
            System.out.println("Donation recorded successfully.");
        } catch (SQLException e) {
            System.out.println("Error recording donation: " + e.getMessage());
        }
    }

    private static void manageAdoptionEvents() {
        try (Connection connection = DBConnection.getDBConnection()) {
            String sql = "SELECT e.EventName, e.EventDate, e.Location, p.ParticipantName, p.ParticipantType FROM AdoptionEvents e " +
                         "JOIN Participants p ON e.EventID = p.EventID";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- Adoption Events ---");
            while (rs.next()) {
                String eventName = rs.getString("EventName");
                String eventDate = rs.getString("EventDate");
                String location = rs.getString("Location");
                String participantName = rs.getString("ParticipantName");
                String participantType = rs.getString("ParticipantType");
                System.out.println("Event: " + eventName + " | Date: " + eventDate + " | Location: " + location +
                                   " | Participant: " + participantName + " | Type: " + participantType);
            }
        } catch (SQLException e) {
            System.out.println("Error managing adoption events: " + e.getMessage());
        }
    }
}
