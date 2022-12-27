package com.ignek.tx.dto;

import com.ignek.tx.entity.PassengerInfo;
import com.ignek.tx.entity.PaymentInfo;

public class FlightBookingRequest {
	
	private PassengerInfo passengerInfo;
	
	private PaymentInfo paymentInfo;

	public PassengerInfo getPassengerInfo() {
		return passengerInfo;
	}

	public void setPassengerInfo(PassengerInfo passengerInfo) {
		this.passengerInfo = passengerInfo;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public FlightBookingRequest(PassengerInfo passengerInfo, PaymentInfo paymentInfo) {
		super();
		this.passengerInfo = passengerInfo;
		this.paymentInfo = paymentInfo;
	}

	public FlightBookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
