package com.tutycarcare.service.beans;

import java.sql.Timestamp;
import java.util.List;

public class Job {

	int id;
	int vehicleId;
	Vehicle vehicle;
	
	Timestamp inTime;
	Timestamp estimatedDelivery;
	Timestamp outTime;
	
	String status;
	
	double estimatedCost;
	double totalCost;
	
	int serviceAdvisorId;

	List<JobLineItem> jobLineItems;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Timestamp getInTime() {
		return inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	public Timestamp getEstimatedDelivery() {
		return estimatedDelivery;
	}

	public void setEstimatedDelivery(Timestamp estimatedDelivery) {
		this.estimatedDelivery = estimatedDelivery;
	}

	public Timestamp getOutTime() {
		return outTime;
	}

	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getServiceAdvisorId() {
		return serviceAdvisorId;
	}

	public void setServiceAdvisorId(int serviceAdvisorId) {
		this.serviceAdvisorId = serviceAdvisorId;
	}

	public List<JobLineItem> getJobLineItems() {
		return jobLineItems;
	}

	public void setJobLineItems(List<JobLineItem> jobLineItems) {
		this.jobLineItems = jobLineItems;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", vehicleId=" + vehicleId + ", vehicle=" + vehicle + ", inTime=" + inTime
				+ ", estimatedDelivery=" + estimatedDelivery + ", outTime=" + outTime + ", status=" + status
				+ ", estimatedCost=" + estimatedCost + ", totalCost=" + totalCost + ", serviceAdvisorId="
				+ serviceAdvisorId + "]";
	}
	
}
