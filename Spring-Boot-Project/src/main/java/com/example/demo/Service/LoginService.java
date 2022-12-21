package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Login;

public interface LoginService {
	
	Login saveLoginDetails(Login login);
	
	List<Login> getAll();
	
	void deleteById(String username);
}
