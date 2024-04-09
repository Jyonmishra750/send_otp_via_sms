package com.example.twiliosms.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twiliosms.config.TwilioConfig;
import com.example.twiliosms.constatnts.OtpStatus;
import com.example.twiliosms.dto.OtpRequestDto;
import com.example.twiliosms.dto.OtpResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TwilioService {
	
	@Autowired
	private TwilioConfig twilioConfig;
	
	Map<String, String> otpMap = new HashMap<>();
	
	public OtpResponseDto sendOtp(OtpRequestDto otpRequestDto) {
		
		OtpResponseDto otpResponseDto = null;
		
		try {
			PhoneNumber to = new PhoneNumber(otpRequestDto.getNumber());
			PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber());
			String otp = generateOtp();
			String otpMessage = "Dear Customer, Your OTP is #*" + otp + "*#. Use this OTP to proceed further. Thank You!!!";
			
			Message message = Message.creator(to, from, otpMessage).create();
			
			otpMap.put(otpRequestDto.getUsername(), otp);
			
			otpResponseDto = new OtpResponseDto(OtpStatus.DELIVERED, otpMessage);
		} catch (Exception e) {
			otpResponseDto = new OtpResponseDto(OtpStatus.FAILED, e.getMessage());
		}
		
		return otpResponseDto;
	}
	
	public String validateOtp(OtpRequestDto otpRequestDto) {
		Set<String> keys = otpMap.keySet();
		String username = null;
		for(String key : keys)
			username = key;
        if (otpRequestDto.getUsername().equals(username)) {
            otpMap.remove(username,otpRequestDto.getOtp());
            return "OTP is valid!";
        } else {
            return "OTP is invalid!";
        }
	}
	
	
	// Generate 6 digit OTP
	public String generateOtp() {
		return new DecimalFormat("000000").format(new Random().nextInt(999999));
	}
	
}
