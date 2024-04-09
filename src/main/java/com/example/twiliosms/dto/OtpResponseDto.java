package com.example.twiliosms.dto;

import com.example.twiliosms.constatnts.OtpStatus;

public class OtpResponseDto {
	
	private OtpStatus otpStatus;
	private String message;
	
	public OtpResponseDto() {
		// TODO Auto-generated constructor stub
	}
	
	public OtpResponseDto(OtpStatus delivered, String otpMessage) {
		this.otpStatus=delivered;
		this.message=otpMessage;
	}
	
	public OtpStatus getOtpStatus() {
		return otpStatus;
	}
	public void setOtpStatus(OtpStatus otpStatus) {
		this.otpStatus = otpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
