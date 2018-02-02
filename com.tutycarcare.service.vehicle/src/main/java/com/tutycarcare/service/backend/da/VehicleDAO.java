package com.tutycarcare.service.backend.da;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tutycarcare.service.backend.mapper.VehicleMapper;
import com.tutycarcare.service.beans.Job;
import com.tutycarcare.service.beans.JobLineItem;
import com.tutycarcare.service.beans.Service;
import com.tutycarcare.service.beans.Vehicle;
import com.tutycarcare.service.beans.VehicleBrand;
import com.tutycarcare.service.beans.VehicleModel;

@Component
public class VehicleDAO {

	@Autowired
	VehicleMapper vehicleMapper;

	@Transactional
	public boolean addVehicle(Vehicle vehicle) {
		boolean isAdded = vehicleMapper.addInsurance(vehicle.getInsurance());
		isAdded &= vehicleMapper.addVehicle(vehicle);
		return isAdded;
	}

	public List<VehicleBrand> getVehicleBrands() {
		List<VehicleBrand>  brandsList;
		brandsList = vehicleMapper.getVehicleBrands();
		return brandsList;
	}

	public List<VehicleModel> getVehicleModels(int brandId) {
		List<VehicleModel>  modelsList;
		modelsList = vehicleMapper.getVehicleModels(brandId);
		return modelsList;
	}

	public boolean addVehicleModel(VehicleModel vehicleModel) {
		boolean isAdded = vehicleMapper.addVehicleModel(vehicleModel);
		return isAdded;
	}

	public List<Vehicle> getVehicles() {
		List<Vehicle>  vehiclesList;
		vehiclesList = vehicleMapper.getVehicles();
		return vehiclesList;
	}

	@Transactional
	public boolean addJob(Job job) {
		double estimatedCost = 0.0;
		for(JobLineItem jobLineItem : job.getJobLineItems()){
			estimatedCost +=  jobLineItem.getEstimatedCost();
		}
		job.setEstimatedCost(estimatedCost);

		boolean isAdded = vehicleMapper.addJob(job);
		
		vehicleMapper.addJobLineItems(job.getJobLineItems(), job.getId());
		
		return isAdded;
	}

	@Transactional
	public boolean updateJob(Job job) {
		double estimatedCost = 0.0;
		for(JobLineItem jobLineItem : job.getJobLineItems()){
			estimatedCost +=  jobLineItem.getEstimatedCost();
		}
		job.setEstimatedCost(estimatedCost);

		boolean isUpdated = vehicleMapper.updateJob(job);
		
		//vehicleMapper.addJobLineItems(job.getJobLineItems(), job.getId());
		
		return isUpdated;
	}
	public List<Service> getServices() {
		List<Service>  servicesList;
		servicesList = vehicleMapper.getServices();
		return servicesList;
	}

	public List<Job> getJobs() {
		List<Job>  jobsList;
		jobsList = vehicleMapper.getJobs();
		return jobsList;
	}

}
