package com.tutycarcare.service.beans;

public class JobLineItem {

	int id;
	int jobId;
	int serviceId;
	Service service;
	String name;
	String description;
	
	double estimatedCost;
	double actualCost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	public double getActualCost() {
		return actualCost;
	}
	public void setActualCost(double actualCost) {
		this.actualCost = actualCost;
	}
	@Override
	public String toString() {
		return "JobLineItems [id=" + id + ", jobId=" + jobId + ", serviceId=" + serviceId + ", service=" + service
				+ ", name=" + name + ", description=" + description + ", estimatedCost=" + estimatedCost + ", actualCost="
				+ actualCost + "]";
	}
	
}
