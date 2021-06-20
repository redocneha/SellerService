package com.pharmc.seller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pharmc.seller.utils.SellerServiceError;
public class SellerLoginResponse {
	

	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SellerServiceError getError() {
		return error;
	}

	public void setError(SellerServiceError error) {
		this.error = error;
	}
	
	private SellerServiceError error;

	public SellerLoginResponse(long id, SellerServiceError error) {
		super();
		this.id = id;
		this.error = error;
	}
	
	
	
}
