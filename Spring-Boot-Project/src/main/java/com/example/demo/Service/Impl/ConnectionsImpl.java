package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceExistsException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.ConnectionsRepository;
import com.example.demo.Service.ConnectionService;
import com.example.demo.entity.Connections;

@Service
public class ConnectionsImpl implements ConnectionService{
	
	@Autowired
	ConnectionsRepository connectionRepository;
	
	@Override
	public Connections saveConnection(Connections connections) {
		if(connectionRepository.existsById(connections.getId())) {
			throw new ResourceExistsException("ResourceExistsException : Duplicate entries not allowed, connection id already present!!");
		}
		return connectionRepository.save(connections);
	}

	@Override
	public List<Connections> getAll() {
		return (List<Connections>) connectionRepository.findAll();
	}

	@Override
	public Optional<Connections> getConnectionById(Integer id) {
		return connectionRepository.findById(id);
	}

	@Override
	public void deleteConnectionById(int id) {
		connectionRepository.deleteById(id);
	}

	@Override
	public Connections updateConnection(Connections connection, int id) throws ResourceNotFoundException {
		Connections c = connectionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Connections id doesn't exists!!"));
		c.setConnectionType(connection.getConnectionType());
		c.setConsumer(connection.getConsumer());
		c.setOldReading(connection.getOldReading());
		c.setAddedOn(connection.getAddedOn());
		connectionRepository.save(c);
		return c;
	}

}
