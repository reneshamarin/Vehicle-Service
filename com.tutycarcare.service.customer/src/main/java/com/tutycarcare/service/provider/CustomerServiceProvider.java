package com.tutycarcare.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutycarcare.service.backend.da.CustomerDAO;
import com.tutycarcare.service.beans.Customer;

@Component
public class CustomerServiceProvider {

	@Autowired
	CustomerDAO customerDAO;
	
	public boolean addCustomer(Customer customer) {
		boolean isAdded = customerDAO.addCustomer(customer);
		return isAdded;
	}

}
