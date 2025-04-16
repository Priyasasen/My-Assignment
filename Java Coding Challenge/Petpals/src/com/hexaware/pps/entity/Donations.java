package com.hexaware.pps.entity;

public abstract class Donations {

	    private String donorName;
	    private double amount;

	   
	    public Donations(String donorName, double amount) {
	        this.donorName = donorName;
	        this.amount = amount;
	    }

	    public String getDonorName() {
	        return donorName;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public abstract void recordDonation();
	}



