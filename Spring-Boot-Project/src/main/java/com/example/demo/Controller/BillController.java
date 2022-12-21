 package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.BillRepository;
import com.example.demo.Service.BillService;
import com.example.demo.entity.Bill;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BillController {
	@Autowired
	BillService billService;
	

	@PostMapping("/bill")
	public Bill save(@RequestBody Bill bill){
		return billService.saveBill(bill);
	}
	
	@GetMapping("/bill")
	public List<Bill> getAllBill(){
		return billService.getAll();
	}
	
	@GetMapping("/bill/{id}")
	public Optional<Bill> getBillById(@PathVariable("id") int id){
		return billService.getBillById(id);
	}
	
	@DeleteMapping("/bill/{id}")
	public void deleteBillById(@PathVariable int id) {
		 billService.deleteBillById(id);
	}
	@PutMapping("/bill/{id}")
	public Bill updateConsumer(@RequestBody Bill bill,@PathVariable int id) throws ResourceNotFoundException {
		return billService.updateBill(bill, id);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/billsMY/{iyear}/{imonth}")
	public List<Bill> getBillsByMonthAndYear(@PathVariable("iyear") int iyear, @PathVariable("imonth") int imonth) {
		return billService.billsByMonthAndYear(iyear,imonth);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/billsAC/{iarea}/{icity}")
	public List<Bill> getBillsByCityAndArea(@PathVariable("iarea") String iarea, @PathVariable("icity") String icity) {
		return  billService.billsByCityAndArea(iarea, icity);
		
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/bill/{inputId}/{currentReading}")
	public int billsGeneratedByConnectionId(@PathVariable("inputId") int inputId,@PathVariable("currentReading") int currentReading) {
		return billService.billsGeneratedByConnectionId(inputId, currentReading);
	}
}
