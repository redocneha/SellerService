package com.pharmc.seller.utils;

import org.springframework.stereotype.Component;

public class SellerServiceError {

	private int errorCode;
	
	private String errorMessage;
	
	private String errorDescription;

	public SellerServiceError(int errorCode, String errorMessage, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorDescription = errorDescription;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
