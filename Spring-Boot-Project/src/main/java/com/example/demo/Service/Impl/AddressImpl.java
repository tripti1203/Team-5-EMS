package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceExistsException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.ConsumerRepository;
import com.example.demo.Service.AddressService;
import com.example.demo.entity.Address;

@Service
public class AddressImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	

	@Override
	public Address saveAddress(Address address) {
		if(addressRepository.existsById(address.getId())) {
			throw new ResourceExistsException("ResourceExistsException  : Duplicate entries not allowed, address id already present!!");
		}
		return addressRepository.save(address);
	}


	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return (List<Address>) addressRepository.findAll();
	}


	@Override
	public void deleteAddressById(int id) {
		addressRepository.deleteById(id);
	}


	@Override
	public Address updateAddress(Address address, int id) throws ResourceNotFoundException {
		Address a = addressRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Address by id doesn't exists!!"));
		a.setArea(address.getArea());
		a.setCity(address.getCity());
		addressRepository.save(a);
		return a;
	}

}
