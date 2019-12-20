package com.infosys.customerdetails.entities;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="customer_registration")
public class CustomerDetailsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="cust_id")
	private long customerId;
	@Column(name="cust_name")
	private String custName;
	@Column(name="mobile_number")
	private long mobileNumber;
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Column(name="location")
	private String location;
	@Column(name="team_Name")
	private String teamName;
	@Column(name="cust_Image")
	private Blob custImage; 
	@OneToOne(mappedBy="customerdetails",cascade=CascadeType.ALL)
	private CustLoginDetailsEntity loginDetails;
	
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

	public Blob getCustImage() {
		return custImage;
	}
	public void setCustImage(Blob custImage) {
		this.custImage = custImage;
	}
	public CustLoginDetailsEntity getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(CustLoginDetailsEntity loginDetails) {
		this.loginDetails = loginDetails;
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
