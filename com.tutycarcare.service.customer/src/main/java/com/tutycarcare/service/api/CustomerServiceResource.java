package com.tutycarcare.service.api;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutycarcare.service.beans.Customer;
import com.tutycarcare.service.beans.ResponseMessage;
import com.tutycarcare.service.provider.CustomerServiceProvider;

@Component
@Path("/customer")
public class CustomerServiceResource {

	@Autowired
	CustomerServiceProvider customerServiceProvider;
	
	@PUT
	@Path("/add_customer")
	public ResponseMessage addCustomer(Customer customer){
		ResponseMessage message = new ResponseMessage();
		boolean isAdded = customerServiceProvider.addCustomer(customer);
		return message;
	}
}
