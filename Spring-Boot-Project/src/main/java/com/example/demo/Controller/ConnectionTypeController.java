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
import com.example.demo.Service.ConnectionTypeService;
import com.example.demo.entity.ConnectionType;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ConnectionTypeController {
	@Autowired
	ConnectionTypeService connectionTypeService;
	
	@PostMapping("/connectionType")
	public ConnectionType save(@RequestBody ConnectionType connectionType){
		return connectionTypeService.saveConnectionType(connectionType);
	}
	
	@GetMapping("/connectionType")
	public List<ConnectionType> getAllConnectionType(){
		return connectionTypeService.getAll();
	}
	
	@GetMapping("/connectionType/{id}")
	public Optional<ConnectionType> getConnectionTypeById(@PathVariable("id") int id){
		return connectionTypeService.getConnectionTypeById(id);
	}
	
	@DeleteMapping("/connectionType/{id}")
	public void deleteConnectionTypeById(@PathVariable int id) {
		 connectionTypeService.deleteConnectionTypeById(id);
	}
	@PutMapping("/connectionType/{id}")
	public ConnectionType updateConnectionType(@RequestBody ConnectionType connectionType,@PathVariable int id) throws ResourceNotFoundException {
		return connectionTypeService.updateConnectionType(connectionType, id);
	}
}
