package com.example.demo.Repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Consumer;

@Repository
public interface ConsumerRepository extends CrudRepository<Consumer,Integer> {

}
