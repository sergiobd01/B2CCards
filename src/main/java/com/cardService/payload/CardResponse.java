package com.cardService.payload;

public class CardResponse {

	
	private String message;
	
	private boolean success;
	

	public CardResponse(String message, boolean success) {
		this.message = message;
		this.success = success;
	}

	
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
}
