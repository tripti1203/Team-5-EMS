package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Connections;

@Repository
public interface ConnectionsRepository extends CrudRepository<Connections,Integer> {

}
