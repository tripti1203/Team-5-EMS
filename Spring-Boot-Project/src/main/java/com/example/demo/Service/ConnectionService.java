package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.entity.Connections;



public interface ConnectionService {
	
	Connections saveConnection(Connections connections);
	List<Connections> getAll();
	Optional<Connections> getConnectionById(Integer id);
	void deleteConnectionById(int id);
	@Transactional
	Connections updateConnection(Connections connection,int id) throws ResourceNotFoundException;
}
