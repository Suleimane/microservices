package com.suleimane.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suleimane.hrworker.entities.Worker;
import com.suleimane.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
    
	@Autowired
	private WorkerRepository workerRepository;
	
//	@Value("${test.config}")
//	private String testConfig;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
		//logger.info("Configuration: " + testConfig.toString());
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> listar(){
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> consultar(@PathVariable Long id){
//		try {
//			Thread.sleep(3000L);
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		logger.info("PORT = " + env.getProperty("local.server.port"));
		Worker worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
