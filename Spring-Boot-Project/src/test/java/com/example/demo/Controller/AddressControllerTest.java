package com.example.demo.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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
import com.example.demo.Service.AddressService;
import com.example.demo.entity.Address;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith( SpringExtension.class)
@WebMvcTest(AddressController.class)
public class AddressControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private AddressService addressService;
	
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
	public void testGetAllAddress() throws Exception{
		List<Address> listAddress = new ArrayList<Address>();
		listAddress.add(new Address(1,"New Town","Kolkata"));
		listAddress.add(new Address(2,"Park Street","Kolkata"));
		listAddress.add(new Address(3,"Jagatdal","Kolkata"));
		listAddress.add(new Address(4,"Barrackpore","Kolkata"));
		listAddress.add(new Address(5,"Naihati","Kolkata"));
		Mockito.when(addressService.getAll()).thenReturn(listAddress);
		MvcResult mvcGetResult = mockMvc.perform(get("/address")).andExpect(status().isOk()).andReturn();
		byte[] bytes = mvcGetResult.getResponse().getContentAsByteArray();
		Path path = Paths.get("adddress.xls");
		Files.write(path, bytes);
	}
	
	@Test
	public void testSaveAddress() throws JsonProcessingException, Exception {
		Address savedAddress = new Address(6,"Bidhannagar","Kolkata");
		mockMvc.perform(post("/address")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(savedAddress)
				)).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void testDeleteAddressById() throws Exception {
		mockMvc.perform(delete("/address/{id}", 1))
		 .andExpect(status().isOk())
		 .andDo(print());
	}
	
}
