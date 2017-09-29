package com.tutycarcare.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutycarcare.service.backend.da.VehicleDAO;
import com.tutycarcare.service.beans.Vehicle;

@Component
public class VehicleServiceProvider {

	@Autowired
	VehicleDAO vehicleDAO;
	
	public boolean addVehicle(Vehicle vehicle) {
		boolean isAdded = vehicleDAO.addVehicle(vehicle);
		return isAdded;
	}

}
