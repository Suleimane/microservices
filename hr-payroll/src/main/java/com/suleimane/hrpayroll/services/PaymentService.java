package com.suleimane.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suleimane.hrpayroll.entities.Payment;
import com.suleimane.hrpayroll.entities.Worker;
import com.suleimane.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
//	@Value("${hr-worker.host}")
//	private String workerHost;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFaignClient;
	
	public Payment getPayment(Long workerId, Integer days) {
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("id", String.valueOf(workerId));
//		
//		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		Worker worker = workerFaignClient.consultar(workerId).getBody();
		
		return new Payment(worker.getName(),worker.getDailyIncome(), days);
	}

}
