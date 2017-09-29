package com.tutycarcare.service.backend.da;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutycarcare.service.backend.mapper.CustomerMapper;
import com.tutycarcare.service.beans.Customer;

@Component
public class CustomerDAO {

	@Autowired
	CustomerMapper customerMapper;
	
	public boolean addCustomer(Customer customer) {
		boolean isAdded = customerMapper.addCustomer(customer);
		return isAdded;
	}

}
