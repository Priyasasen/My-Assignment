package com.hexaware.cm.entity;

import java.util.ArrayList;
import java.util.List;

public class CourierCompanyCollection {
    private List<Courier> couriers = new ArrayList<>();

    public void addCourier(Courier courier) {
        couriers.add(courier);
    }

    public Courier findCourierByTrackingNumber(String trackingNumber) {
        for (Courier c : couriers) {
            if (c.getTrackingNumber().equalsIgnoreCase(trackingNumber)) {
                return c;
            }
        }
        return null;
    }

    public List<Courier> getAllCouriers() {
        return couriers;
    }
}
