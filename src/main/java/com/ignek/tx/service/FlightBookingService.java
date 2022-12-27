package com.ignek.tx.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignek.tx.dto.FlightBookingAcknowledgement;
import com.ignek.tx.dto.FlightBookingRequest;
import com.ignek.tx.entity.PassengerInfo;
import com.ignek.tx.entity.PaymentInfo;
import com.ignek.tx.repo.PassengerInfoRepository;
import com.ignek.tx.repo.PaymentInfoRepository;
import com.ignek.tx.utils.PaymentUtils;

import jakarta.transaction.Transactional;

@Service
public class FlightBookingService {
	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	@Transactional
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightBookingRequest) {
		
//		FlightBookingAcknowledgement acknowledgement = null;
		PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);
		
		PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();
		
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getpId());
		
		paymentInfo.setAmount(passengerInfo.getFare());
		
		paymentInfoRepository.save(paymentInfo);
		
		return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
		
	}

}

