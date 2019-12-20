package com.infosys.customerdetails.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.customerdetails.dto.CustLoginDetailsDTO;
import com.infosys.customerdetails.dto.CustomerDetailsDTO;
import com.infosys.customerdetails.request.CustLoginDetailsRequest;
import com.infosys.customerdetails.request.CustomerDetailsRequest;
import com.infosys.customerdetails.response.CustomerDetailsResponse;
import com.infosys.customerdetails.service.CustomerDetailsService;

@RestController
@CrossOrigin
@RequestMapping
public class CustomerDetailsController {
	
	@Autowired
	private CustomerDetailsService detailService;
	
	
	@PostMapping(value="/CustomerRegistration",consumes = {MediaType.APPLICATION_JSON_VALUE },produces= {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> customerRegistration(@RequestBody CustomerDetailsRequest customerDetailsRequest) throws Exception {
		try {
			CustomerDetailsDTO customerDetailsDTO=new ModelMapper().map(customerDetailsRequest, CustomerDetailsDTO.class);
			detailService.customerRegistration(customerDetailsDTO);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		String msg="SignUp Completed Succesfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);

		
	}
	
	
	@PutMapping(value="/UpdateDetails",consumes = {MediaType.APPLICATION_JSON_VALUE },produces= {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> UpdateDetails(@RequestBody CustomerDetailsRequest customerDetailsRequest) throws Exception {
		try {
			CustomerDetailsDTO customerDetailsDTO=new ModelMapper().map(customerDetailsRequest, CustomerDetailsDTO.class);
			detailService.UpdateDetails(customerDetailsDTO);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		String msg="Updation Succesfull";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/GetCustomerDetails/{username}",consumes = {},produces= {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomerDetailsResponse> getCustomerDetails(@PathVariable("username") String userName) {
		CustomerDetailsDTO customerDetailsDTO=detailService.getCustomerDetails(userName);
		CustomerDetailsResponse customerDetailsResponse=new ModelMapper().map(customerDetailsDTO, CustomerDetailsResponse.class);
		return new ResponseEntity<>(customerDetailsResponse, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/DeactivateAccount/{username}",consumes = {MediaType.APPLICATION_JSON_VALUE },produces= {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteCustomerDetails(@PathVariable("username") String userName) {
		try {
			detailService.deleteCustomerDetails(userName);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		String msg="Account deleted Succefully";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping(value="/GetAllUserName",consumes = {MediaType.APPLICATION_JSON_VALUE },produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	public void getCustomerDetails() {
		detailService.getAllUserName();
		
	}
	
	@GetMapping(value="/checkConnection",consumes = {},produces= {MediaType.APPLICATION_JSON_VALUE ,MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> CheckConnection() {
		
		return new ResponseEntity<String>("Connection Established Successfully!",HttpStatus.OK);
		
		
	}
	
	@GetMapping(value="/",consumes = {},produces= {MediaType.APPLICATION_JSON_VALUE ,MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> hello() {
		return new ResponseEntity<String>("Enter Complete URL",HttpStatus.OK);
		
	}
	
	
	

}
