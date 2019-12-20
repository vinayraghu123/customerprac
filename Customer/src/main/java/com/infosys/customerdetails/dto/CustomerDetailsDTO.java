package com.infosys.customerdetails.dto;

import java.sql.Blob;
import java.util.Date;

import com.infosys.customerdetails.entities.CustLoginDetailsEntity;

public class CustomerDetailsDTO {
	
	private long customerId;
	private String custName;
	private long mobileNumber;
	private Date dateOfBirth;
	private String location;
	private String teamName;
	private Blob custImage;
	private CustLoginDetailsDTO loginDetails;
	
	
	public Blob getCustImage() {
		return custImage;
	}
	public void setCustImage(Blob custImage) {
		this.custImage = custImage;
	}
	public CustLoginDetailsDTO getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(CustLoginDetailsDTO loginDetails) {
		this.loginDetails = loginDetails;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
