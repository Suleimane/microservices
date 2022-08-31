package com.suleimane.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suleimane.hrworker.entities.Worker;
import com.suleimane.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> listar(){
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> consultar(@PathVariable Long id){
		Worker worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
