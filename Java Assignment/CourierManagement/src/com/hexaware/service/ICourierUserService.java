package com.hexaware.service;
import com.hexaware.cm.entity.Courier;
import java.util.List;

public interface ICourierUserService {
    String placeOrder(Courier courier);
    String getOrderStatus(String trackingNumber);  
    boolean cancelOrder(String trackingNumber);  
    List<Courier> getAssignedOrder(int courierStaffId);
    
    void addCourier(Courier courier);
    Courier findCourierByTrackingNumber(String trackingNumber);
    void listAllCouriers(); 
    
}
