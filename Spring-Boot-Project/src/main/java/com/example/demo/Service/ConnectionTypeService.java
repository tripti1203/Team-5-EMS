package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.entity.ConnectionType;

public interface ConnectionTypeService {

	ConnectionType saveConnectionType(ConnectionType type);
	List<ConnectionType> getAll();
	Optional<ConnectionType> getConnectionTypeById(Integer id);
	void deleteConnectionTypeById(int id);
	@Transactional
	ConnectionType updateConnectionType(ConnectionType connectionType,int id) throws ResourceNotFoundException;
}
