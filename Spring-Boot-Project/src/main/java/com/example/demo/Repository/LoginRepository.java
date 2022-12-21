package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, String>{

}
