package com.rentpal.accounts.dto;


public class UserDTO {
	private Long id;
	
	private String email;
	
	private String creationTime;
	
	private boolean verified;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreationTime() { return creationTime; }

	public void setCreationTime(String creationTime) { this.creationTime = creationTime; }

	public boolean isVerified() {
		return verified;
	}
	
	public void setVerified(boolean verified) {
		this.verified = verified;
	}	
}
