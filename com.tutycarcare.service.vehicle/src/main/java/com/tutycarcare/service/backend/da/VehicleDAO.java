package com.tutycarcare.service.backend.da;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutycarcare.service.backend.mapper.VehicleMapper;
import com.tutycarcare.service.beans.Vehicle;

@Component
public class VehicleDAO {

	@Autowired
	VehicleMapper vehicleMapper;
	
	public boolean addVehicle(Vehicle vehicle) {
		boolean isAdded = vehicleMapper.addVehicle(vehicle);
		return isAdded;
	}

}
