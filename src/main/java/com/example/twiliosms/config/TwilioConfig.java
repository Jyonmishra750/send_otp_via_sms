package com.example.twiliosms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ConfigurationProperties(prefix = "twilio")
@Component
public class TwilioConfig {
	
	private String accountSid;
	private String accountAuthToken;
	private String phoneNumber;
	/**
	 * @return the accountSid
	 */
	public String getAccountSid() {
		return accountSid;
	}
	/**
	 * @param accountSid the accountSid to set
	 */
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	/**
	 * @return the accountAuthToken
	 */
	public String getAccountAuthToken() {
		return accountAuthToken;
	}
	/**
	 * @param accountAuthToken the accountAuthToken to set
	 */
	public void setAccountAuthToken(String accountAuthToken) {
		this.accountAuthToken = accountAuthToken;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
