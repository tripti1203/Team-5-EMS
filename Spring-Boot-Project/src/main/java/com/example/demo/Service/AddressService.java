package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.entity.Address;


public interface AddressService {
	
	
	Address saveAddress(Address address);
	List<Address> getAll();
	void deleteAddressById(int id);
	@Transactional
	Address updateAddress(Address address,int id) throws ResourceNotFoundException;
	
}
