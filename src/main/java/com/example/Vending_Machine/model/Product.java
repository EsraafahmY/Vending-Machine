package com.example.Vending_Machine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product implements Serializable{
	    @Id
	    @GeneratedValue
	    @Column(name = "id")
	    private long id;

	    @Column(name = "amount_available")
	    private String amountAvailability;

	    @Column(name = "cost")
	    private String cost;
	    @Column(name = "product_name")
	    private String productName;

	    @Column(name = "seller_id")
	    private String sellerId;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

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
