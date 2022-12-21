package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Service.ConnectionService;
import com.example.demo.entity.Connections;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ConnectionsController {
	@Autowired
	ConnectionService connectionService;
	

	@PostMapping("/connections")
	public Connections save(@RequestBody Connections connections){
		return connectionService.saveConnection(connections);
	}
	
	@GetMapping("/connections")
	public List<Connections> getAllConnection(){
		return connectionService.getAll();
	}
	
	@GetMapping("/connections/{id}")
	public Optional<Connections> getConnectionById(@PathVariable("id") int id){
		return connectionService.getConnectionById(id);
	}
	
	@DeleteMapping("/connections/{id}")
	public void deleteConnectionById(@PathVariable int id) {
		 connectionService.deleteConnectionById(id);
	}
	@PutMapping("/connections/{id}")
	public Connections updateConnectionr(@RequestBody Connections connections,@PathVariable int id) throws ResourceNotFoundException {
		return connectionService.updateConnection(connections, id);
	}
}
