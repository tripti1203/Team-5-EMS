package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.example.demo.Exception.ResourceExistsException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.BillRepository;
import com.example.demo.Service.BillService;
import com.example.demo.entity.Bill;

@Service
public class BillImpl implements BillService {

	@Autowired
	BillRepository billRepository;
	
	@Autowired
		@PersistenceContext
		private EntityManager em;
	
	@Override
	public Bill saveBill(Bill bill) {
		if(billRepository.existsById(bill.getId())) {
			throw new ResourceExistsException("ResourceExistsException  : Duplicate entries not allowed, bill id already present!!");
		}
		return billRepository.save(bill);
	}

	@Override
	public List<Bill> getAll() {
		// TODO Auto-generated method stub
		return (List<Bill>) billRepository.findAll();
	}

	@Override
	public void deleteBillById(int id) {
		billRepository.deleteById(null);
	}

	@Override
	public Bill updateBill(Bill bill, int id) throws ResourceNotFoundException {
		Bill b = billRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bill id doesn't exists!!"));
		b.setConsumer(bill.getConsumer());
		b.setConnectionType(bill.getConnectionType());
		b.setNewReading(bill.getBilledUnits());
		b.setOldReading(bill.getOldReading());
		b.setBilledUnits(bill.getBilledUnits());
		b.setTotalAmount(bill.getTotalAmount());
		b.setDateTime(bill.getDateTime());
		billRepository.save(b);
		return b;
	}

	@Override
	public Optional<Bill> getBillById(int id) {
		return billRepository.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bill> billsByMonthAndYear(int iyear, int imonth) {
		StoredProcedureQuery billByYear = em.createNamedStoredProcedureQuery("billsByMonthAndYear")
				.setParameter("iyear", iyear).setParameter("imonth", imonth);
		return billByYear.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bill> billsByCityAndArea(String iarea, String icity) {
		StoredProcedureQuery billByArea = em.createNamedStoredProcedureQuery("billsByCityAndArea")
				.setParameter("iarea", iarea).setParameter("icity", icity);
		return billByArea.getResultList();
	}

	@Override
	public int billsGeneratedByConnectionId(int inputId, int currentReading) {
		StoredProcedureQuery bills =em.createNamedStoredProcedureQuery("generateBillByConnectionId")
				.setParameter("inputId", inputId).setParameter("currentReading", currentReading);
		return bills.getUpdateCount();
	}	
	
}
