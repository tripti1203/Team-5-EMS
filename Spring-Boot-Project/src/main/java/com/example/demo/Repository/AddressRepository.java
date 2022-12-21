package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.Consumer;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {

}
