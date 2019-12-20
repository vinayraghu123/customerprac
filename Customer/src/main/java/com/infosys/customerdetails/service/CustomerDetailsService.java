package com.infosys.customerdetails.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.infosys.customerdetails.dto.CustLoginDetailsDTO;
import com.infosys.customerdetails.dto.CustomerDetailsDTO;
import com.infosys.customerdetails.entities.CustLoginDetailsEntity;
import com.infosys.customerdetails.entities.CustomerDetailsEntity;
import com.infosys.customerdetails.repository.CustLoginDetailsRepository;
import com.infosys.customerdetails.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsService {
	
	@Autowired
	CustomerDetailsRepository detailsRepository;
	
	@Autowired
	CustLoginDetailsRepository custLoginRepository;

	public void customerRegistration(CustomerDetailsDTO customerDetailsDTO) throws Exception  {
		CustomerDetailsEntity customerDetailsEntity=new ModelMapper().map(customerDetailsDTO, CustomerDetailsEntity.class);
		CustLoginDetailsEntity custLoginDetailsEntity=customerDetailsEntity.getLoginDetails();
		custLoginDetailsEntity.setCustomerdetails(customerDetailsEntity);
		List<String> userName= getAllUserName();
		if(userName.contains(custLoginDetailsEntity.getUsername())) {
			throw new Exception("UserName Already Exists");
		}
		detailsRepository.save(customerDetailsEntity);
	
		
		
	}

	public void UpdateDetails(CustomerDetailsDTO customerDetailsDTO) throws Exception {
		CustomerDetailsEntity customerDetailsEntity=new ModelMapper().map(customerDetailsDTO, CustomerDetailsEntity.class);
//		System.out.println(customerDetailsEntity.getCustomerId());
//		CustLoginDetailsEntity custLoginDetailsEntity=custLoginRepository.findCustomer(customerDetailsEntity.getLoginDetails().getUsername());
//		if(custLoginDetailsEntity==null) {
//			throw new Exception("Record Does Not Exist!");
//		}
//		long customerId=custLoginDetailsEntity.getCustomerdetails().getCustomerId();
		CustomerDetailsEntity customerDetailsEntity2=detailsRepository.findByCustId(customerDetailsDTO.getCustomerId());
		customerDetailsEntity.setLoginDetails(customerDetailsEntity2.getLoginDetails());
		detailsRepository.save(customerDetailsEntity);

		
	
	}

	public CustomerDetailsDTO getCustomerDetails(String userName) {
		CustLoginDetailsEntity custLoginDetailsEntity=custLoginRepository.findCustomer(userName);
		CustomerDetailsEntity customerDetailsEntity2=detailsRepository.findByCustId(custLoginDetailsEntity.getCustomerdetails().getCustomerId());
		CustomerDetailsDTO customerDetailsDTO=new ModelMapper().map(customerDetailsEntity2, CustomerDetailsDTO.class);
		return customerDetailsDTO;
		
		
	}

	public void deleteCustomerDetails(String userName) {
		CustLoginDetailsEntity custLoginDetailsEntity=custLoginRepository.findCustomer(userName);
		CustomerDetailsEntity customerDetailsEntity2=detailsRepository.findByCustId(custLoginDetailsEntity.getCustomerdetails().getCustomerId());
		custLoginRepository.delete(custLoginDetailsEntity);
		detailsRepository.delete(customerDetailsEntity2);
		
	}

	public List<String> getAllUserName() {
		
		
		return custLoginRepository.getUserName();
	}
	

}
