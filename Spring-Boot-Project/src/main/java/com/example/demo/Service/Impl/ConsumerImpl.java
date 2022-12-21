package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceExistsException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.ConsumerRepository;
import com.example.demo.Service.ConsumerService;
import com.example.demo.entity.Consumer;

@Service
public class ConsumerImpl implements ConsumerService{

	@Autowired
	private ConsumerRepository consumerRepository;

	@Override
	public Consumer saveConsumer(Consumer consumer) {
		if(consumerRepository.existsById(consumer.getId())) {
			throw new ResourceExistsException("ResourceExistsException : Duplicate entries not allowed, consumer id already present!!");
		}
		return consumerRepository.save(consumer);
	}

	@Override
	public List<Consumer> getAll() {
		return (List<Consumer>) consumerRepository.findAll();
	}

	@Override
	public Optional<Consumer> getConsumerById(int id) {
		// TODO Auto-generated method stub
		return consumerRepository.findById(id);
	}

	@Override
	public void deleteConsumerById(int id) {
		consumerRepository.deleteById(id);
	}

	@Override
	public Consumer updateConsumer(Consumer consumer,int id) throws ResourceNotFoundException {
		Consumer c = consumerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id doesn't exists!!"));
		c.setFirstName(consumer.getFirstName());
		c.setLastName(consumer.getLastName());
		consumerRepository.save(c);
		return c;
	}	
}
