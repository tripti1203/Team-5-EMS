package com.example.demo.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.BillRepository;
import com.example.demo.Repository.ConnectionTypeRepository;
import com.example.demo.Repository.ConnectionsRepository;
import com.example.demo.Repository.ConsumerRepository;
import com.example.demo.Repository.LoginRepository;
import com.example.demo.Service.ConsumerService;
import com.example.demo.entity.Address;
import com.example.demo.entity.Consumer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith( SpringExtension.class)
@WebMvcTest(ConsumerController.class)
public class ConsumerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private ConsumerService consumerService;
	
	@MockBean
	private AddressRepository addressRepository;
	
	@MockBean
	private ConsumerRepository consumerRepository;
	
	@MockBean
	private ConnectionsRepository connectionRepository;
	
	@MockBean
	private ConnectionTypeRepository connectionTypeRepository;
	
	@MockBean
	private BillRepository billRepository;
	
	@MockBean
	private LoginRepository loginRepository;
	
	@MockBean
	private EntityManagerFactory entityManagerFactory;
	
	@Test
	public void testGetAllConsumer() throws Exception {
		List<Consumer> listConsumer = new ArrayList<Consumer>();
		listConsumer.add(new Consumer(1,"2022-12-17","John","Doe",new Address(1,"New Town","Kolkata")));
		listConsumer.add(new Consumer(2,"2022-12-17","Sarah","Bowling",new Address(2,"Park Street","Kolkata")));
		listConsumer.add(new Consumer(3,"2022-12-17","King","Kochhar",new Address(3,"Jagatdal","Kolkata")));
		listConsumer.add(new Consumer(4,"2022-12-17","Lewis","Calpidi",new Address(4,"Barrackpore","Kolkata")));
		listConsumer.add(new Consumer(5,"2021-6-17","Arya","Stark",new Address(5,"Naihati","Kolkata")));
		Mockito.when(consumerService.getAll()).thenReturn(listConsumer);
		MvcResult mvcGetResult = mockMvc.perform(get("/consumer")).andExpect(status().isOk()).andReturn();
		byte[] bytes = mvcGetResult.getResponse().getContentAsByteArray();
		Path path = Paths.get("consumerList.xls");
		Files.write(path, bytes);
	}
	
	@Test
	public void testSaveConsumer() throws JsonProcessingException, Exception {
		Consumer savedConsumer = new Consumer(6,"Sansa","Stark","2022-12-19",new Address(2,"Park Street","Kolkata"));
		mockMvc.perform(post("/consumer")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(savedConsumer)
				)).andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	
	@Test
	public void testDeleteConsumerById() throws Exception {
		mockMvc.perform(delete("/consumer/{id}", 1))
		 .andExpect(status().isOk())
		 .andDo(print());
	}
	
	@Test
	public void testGetConsumerById() throws Exception {
		int id = 1;
		Consumer consumer = new Consumer(id,"John","Doe","2022-12-17",new Address(1,"New Town","Kolkata"));
		Mockito.when(consumerService.getConsumerById(id)).thenReturn(Optional.of(consumer));
	    mockMvc.perform(get("/consumer/{id}", id))
	         .andExpect(status().isOk())
	         .andExpect(jsonPath("$.id").value(id))
	         .andExpect(jsonPath("$.firstName").value(consumer.getFirstName()))
	         .andExpect(jsonPath("$.lastName").value(consumer.getLastName()))
	         .andExpect(jsonPath("$.addedOn").value(consumer.getAddedOn()))
	         .andExpect(jsonPath("$.address").value(consumer.getAddress()))
	         .andDo(print());
	}
}
