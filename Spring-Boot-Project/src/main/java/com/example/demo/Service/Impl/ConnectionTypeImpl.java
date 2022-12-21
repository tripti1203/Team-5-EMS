package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceExistsException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.ConnectionTypeRepository;
import com.example.demo.Service.ConnectionTypeService;
import com.example.demo.entity.ConnectionType;

@Service
public class ConnectionTypeImpl implements ConnectionTypeService {

	@Autowired
	ConnectionTypeRepository connectionTypeRepository;
	@Override
	public ConnectionType saveConnectionType(ConnectionType type) {
		if(connectionTypeRepository.existsById(type.getId())) {
			throw new ResourceExistsException("ResourceExistsException : Duplicate entries not allowed, connectionType id already present!!");
		}
		return connectionTypeRepository.save(type);
	}

	@Override
	public List<ConnectionType> getAll() {
		return (List<ConnectionType>) connectionTypeRepository.findAll();
	}

	@Override
	public Optional<ConnectionType> getConnectionTypeById(Integer id) {
		return connectionTypeRepository.findById(id);
	}

	@Override
	public ConnectionType updateConnectionType(ConnectionType connectionType , int id) throws ResourceNotFoundException {
		ConnectionType ct = connectionTypeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ConnectionType id doesn't exists!!"));
		ct.setPerUnitCharge(connectionType.getPerUnitCharge());
		ct.setFixedCharge(connectionType.getFixedCharge());
		connectionTypeRepository.save(ct);
		return ct;
	}

	@Override
	public void deleteConnectionTypeById(int id) {
		connectionTypeRepository.deleteById(id);
	}
	
	

}
