package com.example.Vending_Machine.dto;

import javax.persistence.Column;

import com.example.Vending_Machine.model.User;

public class ProductRequestDTO {
	
	   private String amountAvailability;
	    private String cost;
	    private String productName;
	    private String sellerId;

	public String getAmountAvailability() {
		return amountAvailability;
	}

	public void setAmountAvailability(String amountAvailability) {
		this.amountAvailability = amountAvailability;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
}
