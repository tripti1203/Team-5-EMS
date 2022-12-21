package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Service.ConsumerService;
import com.example.demo.entity.Consumer;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@PostMapping("/consumer")
	public Consumer save(@RequestBody Consumer consumer){
		return consumerService.saveConsumer(consumer);
	}
	
	@GetMapping("/consumer")
	public List<Consumer> getAllConsumers(){
		return consumerService.getAll();
	}
	
	@GetMapping("/consumer/{id}")
	public Optional<Consumer> getConsumerById(@PathVariable("id") int id){
		return consumerService.getConsumerById(id);
	}
	
	@DeleteMapping("/consumer/{id}")
	public void deleteConsumerById(@PathVariable("id") int id) {
		consumerService.deleteConsumerById(id);
	}
	
	@PutMapping("/consumer/{id}")
	public Consumer updateConsumer(@RequestBody Consumer consumer,@PathVariable int id) throws ResourceNotFoundException {
		return consumerService.updateConsumer(consumer, id);
	}
}
