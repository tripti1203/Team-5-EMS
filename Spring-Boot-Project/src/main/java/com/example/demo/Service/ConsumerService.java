package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.entity.Consumer;


public interface ConsumerService {
		
	Consumer saveConsumer(Consumer consumer);
	
	List<Consumer> getAll();
	
	Optional<Consumer> getConsumerById(int id);
	
	void deleteConsumerById(int id);
	
	@Transactional
	Consumer updateConsumer(Consumer consumer,int id) throws ResourceNotFoundException;
	
}
