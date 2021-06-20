package com.pharmc.seller.model;

import org.springframework.stereotype.Component;

@Component
public class SellerLoginRequest {
	
	@Override
	public String toString() {
		return "SellerLoginRequest [email=" + email + ", password=" + password + "]";
	}

	private String email;
	
	private String password;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




}
