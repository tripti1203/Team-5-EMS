package com.example.demo.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
import com.example.demo.Service.LoginService;
import com.example.demo.entity.Login;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith( SpringExtension.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private LoginService loginService;
	
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
	public void testGetAllLogin() throws Exception{
		List<Login> listLogin = new ArrayList<Login>();
		listLogin.add(new Login("Admin","Password"));
		Mockito.when(loginService.getAll()).thenReturn(listLogin);
		MvcResult mvcGetResult = mockMvc.perform(get("/login")).andExpect(status().isOk()).andReturn();
		byte[] bytes = mvcGetResult.getResponse().getContentAsByteArray();
		Path path = Paths.get("loginList.xls");
		Files.write(path, bytes);
	}
	
	@Test
	public void testSaveLogin() throws JsonProcessingException, Exception {
		Login savedLogin = new Login("Admin2","Password2");
		mockMvc.perform(post("/login")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(savedLogin)
				)).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void testDeleteLogin() throws Exception {
		String id="Admin";
		mockMvc.perform(delete("/login/{id}", id))
		 .andExpect(status().isOk())
		 .andDo(print());
	}
	
}
