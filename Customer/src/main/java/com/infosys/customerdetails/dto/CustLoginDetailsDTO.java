package com.infosys.customerdetails.dto;

public class CustLoginDetailsDTO {
	
	private long loginId;
	private String username;
	private String password;
	private CustomerDetailsDTO customerdetails;


	public long getLoginId() {
		return loginId;
	}
	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CustomerDetailsDTO getCustomerdetails() {
		return customerdetails;
	}
	public void setCustomerdetails(CustomerDetailsDTO customerdetails) {
		this.customerdetails = customerdetails;
	}


}
