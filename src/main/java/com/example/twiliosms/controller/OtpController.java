package com.example.twiliosms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.twiliosms.dto.OtpRequestDto;
import com.example.twiliosms.dto.OtpResponseDto;
import com.example.twiliosms.service.TwilioService;

@RestController
@RequestMapping("/sms")
//@Slf4j
public class OtpController {
	
	//Logger log = LoggerFactory.getLogger(OtpController.class);

	@Autowired
	private TwilioService twilioService;
	
	@GetMapping("/sending")
	public String processSMS() {
		return "SMS sent";
	}

	@PostMapping("/sendotp")
	public OtpResponseDto sendOtpToUser(@RequestBody OtpRequestDto otpRequestDto) {
		//log.info("inside sendOtp :: "+otpRequestDto.getUsername());
		return twilioService.sendOtp(otpRequestDto);
	}
	@PostMapping("/validateotp")
    public String validateOtpOfUser(@RequestBody OtpRequestDto otpRequestDto) {
		//log.info("inside validateOtp :: "+otpRequestDto.getUsername()+" "+otpRequestDto.getOtp());
		return twilioService.validateOtp(otpRequestDto);
    }
	
}
