package com.tutycarcare.service.beans;

public class VehicleType {

	String make;
	String model;
	String type;
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "VehicleType [make=" + make + ", model=" + model + ", type=" + type + "]";
	}
	
}
