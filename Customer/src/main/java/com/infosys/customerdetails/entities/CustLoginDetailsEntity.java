package com.infosys.customerdetails.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="login_details")
public class CustLoginDetailsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="login_id")
	private long loginId;
	@Column(name="username",unique=true)	
	private String username;
	@Column(name="password")
	private String password;
	@OneToOne
	@JoinColumn(name="customer_id")
	private CustomerDetailsEntity customerdetails;


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
	public CustomerDetailsEntity getCustomerdetails() {
		return customerdetails;
	}
	public void setCustomerdetails(CustomerDetailsEntity customerdetails) {
		this.customerdetails = customerdetails;
	}

}
