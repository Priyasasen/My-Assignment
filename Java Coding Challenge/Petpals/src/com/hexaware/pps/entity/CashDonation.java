package com.hexaware.pps.entity;
import java.util.Date;

	
	public class CashDonation extends Donations {
	    
	    private Date donationDate;


	    public CashDonation(String donorName, double amount, Date donationDate) {
	        super(donorName, amount);  
	        this.donationDate = donationDate;
	    }

	  
	    public Date getDonationDate() {
	        return donationDate;
	    }

	  
	    @Override
	    public void recordDonation() {
	      
	        System.out.println("Recording Cash Donation:");
	        System.out.println("Donor Name: " + getDonorName());
	        System.out.println("Amount: " + getAmount());
	        System.out.println("Donation Date: " + donationDate);
	    }
	}



