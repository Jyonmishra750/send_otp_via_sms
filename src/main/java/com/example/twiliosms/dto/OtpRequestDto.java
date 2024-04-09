package com.example.twiliosms.dto;

public class OtpRequestDto {
	
	private String otp;
	private String username;
	private String number; // where the 'OTP' will be send
	
	
	public String getOtp() {
		return otp;
	}
	
	void setOtp(String otp) {
		this.otp = otp;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
