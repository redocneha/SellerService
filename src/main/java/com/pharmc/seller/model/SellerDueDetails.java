package com.pharmc.seller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.micrometer.core.lang.NonNull;

@Entity
@Table(name="seller_due_details")
public class SellerDueDetails {

	 @Id
	 @NonNull
	 private long sid ;
	
	 @Column(name="credit_amount")
	 private double creditableAmount;

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public double getCreditableAmount() {
		return creditableAmount;
	}

	public void setCreditableAmount(double creditableAmount) {
		this.creditableAmount = creditableAmount;
	}
	  
}
