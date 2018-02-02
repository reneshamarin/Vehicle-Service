package com.tutycarcare.service.beans;

public class VehicleBrand {

	int id;
	String name;
	String description;
	int sortorder;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getSortorder() {
		return sortorder;
	}
	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}
	@Override
	public String toString() {
		return "VehicleBrand [id=" + id + ", name=" + name + ", description=" + description + ", sortorder=" + sortorder
				+ "]";
	}
	
}
