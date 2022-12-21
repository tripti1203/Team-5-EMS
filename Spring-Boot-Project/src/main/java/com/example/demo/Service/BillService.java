package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.entity.Bill;

public interface BillService {
	
	Bill saveBill(Bill bill);
	
	List<Bill> getAll();
	
	Optional<Bill> getBillById(int id);
	
	void deleteBillById(int id);
	
	@Transactional
	Bill updateBill(Bill bill,int id) throws ResourceNotFoundException;
	
	@Procedure(procedureName="billsByMonthAndYear")
	List<Bill> billsByMonthAndYear(int iyear, int imonth);
	
	
	@Procedure(procedureName="billsByCityAndArea")
	List<Bill> billsByCityAndArea(String iarea, String icity);
	
	
	@Procedure(procedureName="generateBillByConnectionId")
	int billsGeneratedByConnectionId(int inputId,int currentReading);
	
}

