package com.hexaware.cm.dao;

import com.hexaware.cm.connectionutil.DBConnection;
import java.sql.*;

public class CourierServiceDb {
    private static Connection connection;

    
    public CourierServiceDb() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCourier(int courierId, int senderId, int receiverId, double weight, String status, String trackingNumber, Date deliveryDate, int handledByEmployeeId, Date sentDate) {
        String query = "INSERT INTO Courier (CourierID, SenderID, ReceiverID, Weight, Status, TrackingNumber, DeliveryDate, HandledByEmployeeID, SentDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, courierId);
            ps.setInt(2, senderId);
            ps.setInt(3, receiverId);
            ps.setDouble(4, weight);
            ps.setString(5, status);
            ps.setString(6, trackingNumber);
            ps.setDate(7, deliveryDate);
            ps.setInt(8, handledByEmployeeId);
            ps.setDate(9, sentDate);
            ps.executeUpdate();
            System.out.println("Courier inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourierStatus(int courierId, String newStatus) {
        String query = "UPDATE Courier SET Status = ? WHERE CourierID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, newStatus);
            ps.setInt(2, courierId);
            ps.executeUpdate();
            System.out.println("Status updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDeliveryDetails(int courierId) {
        String query = "SELECT * FROM Courier WHERE CourierID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, courierId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Courier ID: " + rs.getInt("CourierID"));
                System.out.println("Sender ID: " + rs.getInt("SenderID"));
                System.out.println("Receiver ID: " + rs.getInt("ReceiverID"));
                System.out.println("Weight: " + rs.getDouble("Weight"));
                System.out.println("Status: " + rs.getString("Status"));
                System.out.println("Tracking Number: " + rs.getString("TrackingNumber"));
                System.out.println("Delivery Date: " + rs.getDate("DeliveryDate"));
                System.out.println("Handled By Employee ID: " + rs.getInt("HandledByEmployeeID"));
                System.out.println("Sent Date: " + rs.getDate("SentDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    public void generateShipmentReport() {
        String query = "SELECT Status, COUNT(*) AS count FROM Courier GROUP BY Status";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Shipment Status Report:");
            while (rs.next()) {
                System.out.println(rs.getString("Status") + ": " + rs.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generateRevenueReport() {
        String query = "SELECT SUM(P.Amount) AS total_revenue FROM Payment P JOIN Courier C ON P.CourierID = C.CourierID";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.out.println("Total Revenue: " + rs.getDouble("total_revenue"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
