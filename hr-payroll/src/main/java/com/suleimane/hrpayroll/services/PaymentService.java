package com.suleimane.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.suleimane.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Íris", 200.0, days);
	}

}
