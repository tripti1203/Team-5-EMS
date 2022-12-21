package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceExistsException;
import com.example.demo.Repository.LoginRepository;
import com.example.demo.Service.LoginService;
import com.example.demo.entity.Login;

@Service
public class LoginImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public Login saveLoginDetails(Login login) {
		if(loginRepository.existsById(login.getUsername())) {
			throw new ResourceExistsException("ResourceExistsException : Duplicate entries not allowed, username already present!!");
		}
		return loginRepository.save(login);
	}

	@Override
	public List<Login> getAll() {
		return (List<Login>) loginRepository.findAll();
	}

	@Override
	public void deleteById(String username) {
		loginRepository.deleteById(username);
	}
	
}
