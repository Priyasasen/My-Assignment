package com.hexaware.cm.dao;
import com.hexaware.cm.entity.Courier;
import com.hexaware.cm.entity.CourierCompanyCollection;
import com.hexaware.cm.service.ICourierUserService;

import java.util.List;

public class CourierUserServiceCollectionImpl implements ICourierUserService {
    private CourierCompanyCollection company = new CourierCompanyCollection();

    @Override
    public void addCourier(Courier courier) {
        company.addCourier(courier);
        System.out.println("Courier added: " + courier);
    }

    @Override
    public Courier findCourierByTrackingNumber(String trackingNumber) {
        return company.findCourierByTrackingNumber(trackingNumber);
    }

    @Override
    public void listAllCouriers() {
        for (Courier c : company.getAllCouriers()) {
            System.out.println(c);
        }
    }

	@Override
	public String placeOrder(Courier courier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrderStatus(String trackingNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelOrder(String trackingNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Courier> getAssignedOrder(int courierStaffId) {
		// TODO Auto-generated method stub
		return null;
	}
}
