package com.infosys.customerdetails.request;

public class CustLoginDetailsRequest {
	
	private long loginId;
	private String username;
	private String password;
	private CustomerDetailsRequest customerdetails;


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
	public CustomerDetailsRequest getCustomerdetails() {
		return customerdetails;
	}
	public void setCustomerdetails(CustomerDetailsRequest customerdetails) {
		this.customerdetails = customerdetails;
	}


}
