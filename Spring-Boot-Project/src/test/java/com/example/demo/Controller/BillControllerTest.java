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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.BillRepository;
import com.example.demo.Repository.ConnectionTypeRepository;
import com.example.demo.Repository.ConnectionsRepository;
import com.example.demo.Repository.ConsumerRepository;
import com.example.demo.Repository.LoginRepository;
import com.example.demo.Service.BillService;
import com.example.demo.Service.ConnectionTypeService;
import com.example.demo.entity.Address;
import com.example.demo.entity.Bill;
import com.example.demo.entity.ConnectionType;
import com.example.demo.entity.Connections;
import com.example.demo.entity.Consumer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BillController.class)
public class BillControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private BillService billService;
	
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
	public void testGetAllBill() throws Exception {
		List<Bill> listBill = new ArrayList<Bill>();
		listBill.add(new Bill(1,new Consumer(1,"John","Doe","2022-12-17",new Address(1,"New Town","Kolkata"))
				,new Connections(1,new Consumer(1,"John","Doe","2022-12-17",new Address(1,"New Town","Kolkata"))
				,new ConnectionType(1,"Domestic",250.45,2),4973,"2022-12-17"),new ConnectionType(1,"Domestic",250.45,2),"2022-12-20 11:34:33",4500,4973,473,1196.45));
		
		listBill.add(new Bill(2,new Consumer(2,"Sarah","Bowling","2022-12-17",new Address(2,"Park Street","Kolkata"))
				,new Connections(2,new Consumer(2,"Sarah","Bowling","2022-12-17",new Address(2,"Park Street","Kolkata"))
				,new ConnectionType(2,"Commercial",350.67,4),5000,"2022-12-17"),new ConnectionType(2,"Commercial",350.67,4),"2022-12-20 11:35:13",4600,5000,400,1950.67));
		
		Mockito.when(billService.getAll()).thenReturn(listBill);
		MvcResult mvcGetResult = mockMvc.perform(get("/bill")).andExpect(status().isOk()).andReturn();
		byte[] bytes = mvcGetResult.getResponse().getContentAsByteArray();
		Path path = Paths.get("billList.xls");
		Files.write(path, bytes);
	}
	
	@Test
	public void testSaveBill() throws JsonProcessingException, Exception {
		Bill savedBill = new Bill(3,new Consumer(3,"King","Kochhar","2022-12-17",new Address(3,"Naihati","Kolkata"))
				,new Connections(3,new Consumer(3,"King","Kochhar","2022-12-17",new Address(3,"Naihati","Kolkata"))
				,new ConnectionType(1,"Domestic",250.45,2),4700,"2022-12-17"),new ConnectionType(1,"Domestic",250.45,2),"2022-12-17",0,0,0,0);
		mockMvc.perform(post("/bill")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(savedBill)
				)).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void testDeleteConnectionTypeById() throws Exception {
		mockMvc.perform(delete("/bill/{id}", 1))
		 .andExpect(status().isOk())
		 .andDo(print());
	}
	
	@Test
	public void testGetConnectionTypeById() throws Exception {
		int id = 2;
		Bill savedBill = new Bill(id,new Consumer(2,"Sarah","Bowling","2022-12-17",new Address(2,"Park Street","Kolkata"))
				,new Connections(2,new Consumer(2,"Sarah","Bowling","2022-12-17",new Address(2,"Park Street","Kolkata"))
				,new ConnectionType(2,"Commercial",350.67,4),5000,"2022-12-17"),new ConnectionType(2,"Commercial",350.67,4),"2022-12-20 11:35:13",4600,5000,400,1950.67);
		Mockito.when(billService.getBillById(id)).thenReturn(Optional.of(savedBill));
	    mockMvc.perform(get("/bill/{id}", id))
	         .andExpect(status().isOk())
	         .andExpect(jsonPath("$.id").value(id))
	         .andExpect(jsonPath("$.consumer").value(savedBill.getConsumer()))
	         .andExpect(jsonPath("$.connections").value(savedBill.getConnections()))
	         .andExpect(jsonPath("$.connectionType").value(savedBill.getConnectionType()))
	         .andExpect(jsonPath("$.dateTime").value(savedBill.getDateTime()))
	         .andExpect(jsonPath("$.oldReading").value(savedBill.getOldReading()))
	         .andExpect(jsonPath("$.newReading").value(savedBill.getNewReading()))
	         .andExpect(jsonPath("$.billedUnits").value(savedBill.getBilledUnits()))
	         .andExpect(jsonPath("$.totalAmount").value(savedBill.getTotalAmount()))
	         .andDo(print());
	}
}
