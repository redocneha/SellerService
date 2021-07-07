package com.pharmc.seller.model;

import org.springframework.stereotype.Component;

@Component
public class GenericeErrorResponse {
	
	private long errorId;
	
	private String errorDescription;
	
	private String apiDetails;

	public long getErrorId() {
		return errorId;
	}

	public void setErrorId(long errorId) {
		this.errorId = errorId;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getApiDetails() {
		return apiDetails;
	}

	public void setApiDetails(String apiDetails) {
		this.apiDetails = apiDetails;
	}

}
