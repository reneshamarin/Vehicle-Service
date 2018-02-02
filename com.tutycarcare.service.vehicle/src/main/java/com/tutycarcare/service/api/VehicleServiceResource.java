package com.tutycarcare.service.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutycarcare.service.beans.Job;
import com.tutycarcare.service.beans.ResponseMessage;
import com.tutycarcare.service.beans.Service;
import com.tutycarcare.service.beans.Vehicle;
import com.tutycarcare.service.beans.VehicleBrand;
import com.tutycarcare.service.beans.VehicleModel;
import com.tutycarcare.service.constants.ParameterConstants;
import com.tutycarcare.service.provider.VehicleServiceProvider;

@Component
@Path("/vehicle")
public class VehicleServiceResource {

	@Autowired
	VehicleServiceProvider vehicleServiceProvider;
	
	@PUT
	@Path("/add_vehicle")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseMessage addVehicle(Vehicle vehicle){
		ResponseMessage message = new ResponseMessage();
		boolean isAdded = vehicleServiceProvider.addVehicle(vehicle);
		return message;
	}
	
	@GET
	@Path("/get_vehicles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehicle> getVehicles(){
		List<Vehicle>  vehiclesList;
		vehiclesList = vehicleServiceProvider.getVehicles();
		return vehiclesList;
	}
	
	@GET
	@Path("/get_vehicle_brands")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VehicleBrand> getVehicleBrands(){
		List<VehicleBrand>  brandsList;
		brandsList = vehicleServiceProvider.getVehicleBrands();
		return brandsList;
	}
	
	@GET
	@Path("/get_vehicle_models")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VehicleModel> getVehicleModels(@QueryParam(ParameterConstants.BRAND_ID) int brandId){
		List<VehicleModel>  modelsList;
		modelsList = vehicleServiceProvider.getVehicleModels(brandId);
		return modelsList;
	}
	
	@GET
	@Path("/get_services")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Service> getServices(){
		List<Service>  servicesList;
		servicesList = vehicleServiceProvider.getServices();
		return servicesList;
	}
	
	@GET
	@Path("/get_jobs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Job> getJobs(){
		List<Job>  jobsList;
		jobsList = vehicleServiceProvider.getJobs();
		return jobsList;
	}
	
	@PUT
	@Path("/create_job")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseMessage createJob(Job job){
		ResponseMessage message = new ResponseMessage();
		boolean isAdded = vehicleServiceProvider.addJob(job);
		return message;
	}
	
	@PUT
	@Path("/update_job")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseMessage updateJob(Job job){
		ResponseMessage message = new ResponseMessage();
		boolean isUpdated = vehicleServiceProvider.updateJob(job);
		return message;
	}
	
	
}
