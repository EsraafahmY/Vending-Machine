package com.example.Vending_Machine.dto;

import com.example.Vending_Machine.model.*;

public class ProductResponseDTO {

	private long id;
	   private long amountAvailability;
	    private long cost;
	    private String productName;
	    private User sellerId;
		public long getAmountAvailability() {
			return amountAvailability;
		}
		public void setAmountAvailability(long amountAvailability) {
			this.amountAvailability = amountAvailability;
		}
		public long getCost() {
			return cost;
		}
		public void setCost(long cost) {
			this.cost = cost;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public User getSellerId() {
			return sellerId;
		}
		public void setSellerId(User sellerId) {
			this.sellerId = sellerId;
		}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
