package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LoginService;
import com.example.demo.entity.Login;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public Login saveLoginDetails(@RequestBody Login login) {
		return loginService.saveLoginDetails(login);
	}
	
	@GetMapping("/login")
	public List<Login> getAllLogin(){
		return loginService.getAll();
	}
	
	@DeleteMapping("/login/{username}")
	public void deleteById(@PathVariable("username") String username) {
		loginService.deleteById(username);
	}
}
