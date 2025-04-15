package com.hexaware.cm.main;

import java.sql.Date;
import java.util.Scanner;
import com.hexaware.cm.dao.CourierServiceDb;

public class CourierManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourierServiceDb service = new CourierServiceDb();

        while (true) {
            System.out.println("\n--- COURIER MANAGEMENT SYSTEM ---");
            System.out.println("1. Insert New Courier");
            System.out.println("2. Update Courier Status");
            System.out.println("3. Get Delivery Details");
            System.out.println("4. Generate Shipment Report");
            System.out.println("5. Generate Revenue Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Courier ID: ");
                        int courierId = Integer.parseInt(sc.nextLine());

                        System.out.print("Sender ID: ");
                        int senderId = Integer.parseInt(sc.nextLine());

                        System.out.print("Receiver ID: ");
                        int receiverId = Integer.parseInt(sc.nextLine());

                        System.out.print("Weight: ");
                        double weight = Double.parseDouble(sc.nextLine());

                        System.out.print("Status: ");
                        String status = sc.nextLine();

                        System.out.print("Tracking Number: ");
                        String trackingNumber = sc.nextLine();

                        System.out.print("Delivery Date (yyyy-mm-dd): ");
                        Date deliveryDate = Date.valueOf(sc.nextLine());

                        System.out.print("Handled By Employee ID: ");
                        int empId = Integer.parseInt(sc.nextLine());

                        System.out.print("Sent Date (yyyy-mm-dd): ");
                        Date sentDate = Date.valueOf(sc.nextLine());

                        service.insertCourier(courierId, senderId, receiverId, weight, status, trackingNumber, deliveryDate, empId, sentDate);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Courier ID to update status: ");
                        int cid = Integer.parseInt(sc.nextLine());
                        System.out.print("New Status: ");
                        String newStatus = sc.nextLine();
                        service.updateCourierStatus(cid, newStatus);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter Courier ID: ");
                        int cid = Integer.parseInt(sc.nextLine());
                        service.getDeliveryDetails(cid);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    service.generateShipmentReport();
                    break;

                case 5:
                    service.generateRevenueReport();
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    CourierServiceDb.closeConnection();

                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }
        }
    }
}
