package com.hexaware.pps.entity;

public class ItemDonation extends Donations {
	
	 private String itemType;

	    
	    public ItemDonation(String donorName, double amount, String itemType) {
	        super(donorName, amount);
	        this.itemType = itemType;
	    }

	   
	    public String getItemType() {
	        return itemType;
	    }


	    public void setItemType(String itemType) {
	        this.itemType = itemType;
	    }

	   
	    @Override
	    public void recordDonation() {
	        System.out.println("Item Donation recorded:");
	        System.out.println("Donor Name: " + getDonorName());
	        System.out.println("Item Type: " + itemType);
	        System.out.println("Amount: Rs." + getAmount());
	    }
	}


