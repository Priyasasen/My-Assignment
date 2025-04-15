package com.hexaware.cm.service;
import com.hexaware.cm.entity.Courier;
import java.util.ArrayList;
import java.util.List;


public class CourierUserServiceImpl implements ICourierUserService {

    private List<Courier> courierList = new ArrayList<>();
    
    @Override
    public String placeOrder(Courier courier) {
        courierList.add(courier);  
        return courier.getTrackingNumber();  
    }

    @Override
    public String getOrderStatus(String trackingNumber) {
        for (Courier c : courierList) {
            if (c.getTrackingNumber().equals(trackingNumber)) {
                return c.getStatus();  
            }
        }
        return "Order not found";  
    }

    @Override
    public boolean cancelOrder(String trackingNumber) {
        for (Courier c : courierList) {
            if (c.getTrackingNumber().equals(trackingNumber)) {
                courierList.remove(c);  
                return true; 
            }
        }
        return false;  
    }

    @Override
    public List<Courier> getAssignedOrder(int courierStaffId) {
       
        List<Courier> assignedOrders = new ArrayList<>();
        for (Courier c : courierList) {
            if (c.getUserId() == courierStaffId) {
                assignedOrders.add(c);  
            }
        }
        return assignedOrders; 
    }

	@Override
	public void addCourier(Courier courier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Courier findCourierByTrackingNumber(String trackingNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listAllCouriers() {
		// TODO Auto-generated method stub
		
	}
}