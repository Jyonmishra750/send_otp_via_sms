package com.example.twiliosms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.twiliosms.config.TwilioConfig;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties
public class TwilioSmsExampleApplication {
	
	@Autowired
	private TwilioConfig twilioConfig;
	
	@PostConstruct
	public void initTwilio() {
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAccountAuthToken());
	}

	public static void main(String[] args) {
		SpringApplication.run(TwilioSmsExampleApplication.class, args);
	}

}
