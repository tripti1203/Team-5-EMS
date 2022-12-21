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
import com.example.demo.Service.ConnectionTypeService;
import com.example.demo.entity.ConnectionType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith( SpringExtension.class)
@WebMvcTest(ConnectionTypeController.class)
public class ConnectionTypeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private ConnectionTypeService connectionTypeService;
	
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
	public void testGetAllConnectionType() throws Exception {
		List<ConnectionType> listConnectionType = new ArrayList<ConnectionType>();
		listConnectionType.add(new ConnectionType(1,"Domestic",250.45,2));
		listConnectionType.add(new ConnectionType(2,"Commercial",350.67,4));
		Mockito.when(connectionTypeService.getAll()).thenReturn(listConnectionType);
		MvcResult mvcGetResult = mockMvc.perform(get("/connectionType")).andExpect(status().isOk()).andDo(print()).andReturn();
		byte[] bytes = mvcGetResult.getResponse().getContentAsByteArray();
		Path path = Paths.get("connectionTypeList.xls");
		Files.write(path, bytes);
	}
	
	@Test
	public void testSaveConnectionType() throws JsonProcessingException, Exception {
		ConnectionType savedConnectionType = new ConnectionType(3,"Heavy Load",450.3,6);
		mockMvc.perform(post("/connectionType")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(savedConnectionType)
				)).andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	
	@Test
	public void testDeleteConnectionTypeById() throws Exception {
		mockMvc.perform(delete("/connectionType/{id}", 1))
		 .andExpect(status().isOk())
		 .andDo(print());
	}
	
	@Test
	public void testGetConnectionTypeById() throws Exception {
		int id = 2;
		ConnectionType savedConnectionType = new ConnectionType(id,"Commercial",350.67,4);
		Mockito.when(connectionTypeService.getConnectionTypeById(id)).thenReturn(Optional.of(savedConnectionType));
	    mockMvc.perform(get("/connectionType/{id}", id))
	         .andExpect(status().isOk())
	         .andExpect(jsonPath("$.id").value(id))
	         .andExpect(jsonPath("$.type").value(savedConnectionType.getType()))
	         .andExpect(jsonPath("$.fixedCharge").value(savedConnectionType.getFixedCharge()))
	         .andExpect(jsonPath("$.perUnitCharge").value(savedConnectionType.getPerUnitCharge()))
	         .andDo(print());
	}
}
