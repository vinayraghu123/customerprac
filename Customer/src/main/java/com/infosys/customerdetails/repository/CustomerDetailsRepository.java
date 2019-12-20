package com.infosys.customerdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.customerdetails.entities.CustomerDetailsEntity;


@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetailsEntity, Long>{

	@Query(value="select * from customer_registration  where cust_id=:customerId",nativeQuery=true)
	CustomerDetailsEntity findByCustId(long customerId);

	

}
