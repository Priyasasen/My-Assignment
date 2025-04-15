package com.hexaware.service;

public class CourierAdminServiceImpl implements ICourierAdminService {

    @Override
    public int addCourierStaff(String name, String contactNumber) {
        // Adding logic for courier staff
        System.out.println("New courier staff added: Name - " + name + ", Contact - " + contactNumber);
        return (int) (Math.random() * 1000);  // Example random ID generation
    }
}