package com.tutycarcare.service.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutycarcare.service.backend.da.VehicleDAO;
import com.tutycarcare.service.beans.Job;
import com.tutycarcare.service.beans.Service;
import com.tutycarcare.service.beans.Vehicle;
import com.tutycarcare.service.beans.VehicleBrand;
import com.tutycarcare.service.beans.VehicleModel;

@Component
public class VehicleServiceProvider {

	@Autowired
	VehicleDAO vehicleDAO;
	
	public boolean addVehicle(Vehicle vehicle) {
		boolean isAdded = vehicleDAO.addVehicle(vehicle);
		return isAdded;
	}

	public List<VehicleBrand> getVehicleBrands() {
		List<VehicleBrand>  brandsList;
		brandsList = vehicleDAO.getVehicleBrands();
		return brandsList;
	}

	public List<VehicleModel> getVehicleModels(int brandId) {
		List<VehicleModel>  modelsList;
		modelsList = vehicleDAO.getVehicleModels(brandId);
		return modelsList;
	}

	public boolean addVehicleModel(VehicleModel vehicleModel) {
		boolean isAdded = vehicleDAO.addVehicleModel(vehicleModel);
		return isAdded;
	}

	public List<Vehicle> getVehicles() {
		List<Vehicle>  vehiclesList;
		vehiclesList = vehicleDAO.getVehicles();
		return vehiclesList;
	}

	public boolean addJob(Job job) {
		boolean isAdded = vehicleDAO.addJob(job);
		return isAdded;
	}
	public boolean updateJob(Job job) {
		boolean isAdded = vehicleDAO.updateJob(job);
		return isAdded;
	}

	public List<Service> getServices() {
		List<Service>  servicesList;
		servicesList = vehicleDAO.getServices();
		return servicesList;
	}

	public List<Job> getJobs() {
		List<Job>  jobsList;
		jobsList = vehicleDAO.getJobs();
		return jobsList;
	}

}
