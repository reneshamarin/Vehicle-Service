package com.tutycarcare.service.api;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutycarcare.service.beans.ResponseMessage;
import com.tutycarcare.service.beans.Vehicle;
import com.tutycarcare.service.provider.VehicleServiceProvider;

@Component
@Path("/vehicle")
public class VehicleServiceResource {

	@Autowired
	VehicleServiceProvider vehicleServiceProvider;
	
	@PUT
	@Path("/add_vehicle")
	public ResponseMessage addVehicle(Vehicle vehicle){
		ResponseMessage message = new ResponseMessage();
		boolean isAdded = vehicleServiceProvider.addVehicle(vehicle);
		return message;
	}
}
