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
import com.example.demo.Service.ConnectionService;
import com.example.demo.Service.ConnectionTypeService;
import com.example.demo.entity.Address;
import com.example.demo.entity.ConnectionType;
import com.example.demo.entity.Connections;
import com.example.demo.entity.Consumer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith( SpringExtension.class)
@WebMvcTest(ConnectionsController.class)
public class ConnectionsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private ConnectionService connectionService;
	
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
	public void testGetAllConnection() throws Exception {
		List<Connections> listConnections = new ArrayList<Connections>();
		listConnections.add(new Connections(1,new Consumer(1,"John","Doe","2022-12-17",new Address(1,"New Town","Kolkata")),
				new ConnectionType(1,"Domestic",250.45,2),4500,"2022-12-17"));
		
		listConnections.add(new Connections(2,new Consumer(2,"Sarah","Doe","2022-12-17",new Address(2,"Park Street","Kolkata")),
				new ConnectionType(2,"Commercialc",350.67,4),4600,"2022-12-17"));
		
		Mockito.when(connectionService.getAll()).thenReturn(listConnections);
		MvcResult mvcGetResult = mockMvc.perform(get("/connections")).andExpect(status().isOk()).andReturn();
		byte[] bytes = mvcGetResult.getResponse().getContentAsByteArray();
		Path path = Paths.get("connectionsList.xls");
		Files.write(path, bytes);
	}
	
	@Test
	public void testSaveConnection() throws JsonProcessingException, Exception {
		Connections savedConnections = new Connections(3,new Consumer(3,"King","Kochhar","2022-12-17",new Address(3,"Jagatdal","Kolkata")),
				new ConnectionType(1,"Domestic",250.45,2),4700,"2022-12-17");
		mockMvc.perform(post("/connections")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(savedConnections)
				)).andExpect(status().isOk())
				.andDo(print())
				.andReturn();
	}
	
	@Test
	public void testDeleteConnectionById() throws Exception {
		mockMvc.perform(delete("/connections/{id}", 1))
		 .andExpect(status().isOk())
		 .andDo(print());
	}
	
	@Test
	public void testGetConnectionById() throws Exception {
		int id = 1;
		Connections savedConnections = new Connections(id,new Consumer(1,"John","Doe","2022-12-17",new Address(1,"New Town","Kolkata")),
				new ConnectionType(2,"Commercial",350.67,4),4500,"2022-12-17");
		Mockito.when(connectionService.getConnectionById(id)).thenReturn(Optional.of(savedConnections));
	    mockMvc.perform(get("/connections/{id}", id))
	         .andExpect(status().isOk())
	         .andExpect(jsonPath("$.id").value(id))
	         .andExpect(jsonPath("$.consumer").value(savedConnections.getConsumer()))
	         .andExpect(jsonPath("$.connectionType").value(savedConnections.getConnectionType()))
	         .andExpect(jsonPath("$.oldReading").value(savedConnections.getOldReading()))
	         .andExpect(jsonPath("$.addedOn").value(savedConnections.getAddedOn()))
	         .andDo(print());
	}
}
