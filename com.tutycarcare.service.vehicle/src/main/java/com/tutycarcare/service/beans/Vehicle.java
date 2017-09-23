package com.tutycarcare.service.beans;

public class Vehicle {

	int id;
	VehicleType vehicleType;
	Insurance insurance;
	String registrationNumber;
	String color;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleType=" + vehicleType + ", insurance=" + insurance + ", registrationNumber="
				+ registrationNumber + ", color=" + color + "]";
	}
	
	
}
