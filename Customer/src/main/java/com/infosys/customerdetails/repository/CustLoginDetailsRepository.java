package com.infosys.customerdetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.customerdetails.entities.CustLoginDetailsEntity;

@Repository
public interface CustLoginDetailsRepository extends JpaRepository<CustLoginDetailsEntity,Long>{

	@Query(value="select * from login_details where username=:username",nativeQuery=true)
	public CustLoginDetailsEntity  findCustomer(String username);

	@Query(value="select username from login_details",nativeQuery=true)
	public List<String> getUserName();
	

}
