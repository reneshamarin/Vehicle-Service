package com.tutycarcare.service.beans;

import java.sql.Date;

public class Customer {

	String firstname;
	String middlename;
	String lastname;
	String address;
	String mobile;
	String email;
	Date dob;
	Date dom;
	
	String licenseNumber;
	Date licenseExpiry;
	
	String type;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDom() {
		return dom;
	}

	public void setDom(Date dom) {
		this.dom = dom;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Date getLicenseExpiry() {
		return licenseExpiry;
	}

	public void setLicenseExpiry(Date licenseExpiry) {
		this.licenseExpiry = licenseExpiry;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Customer [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", address=" + address + ", mobile=" + mobile + ", email=" + email + ", dob=" + dob + ", dom=" + dom
				+ ", licenseNumber=" + licenseNumber + ", licenseExpiry=" + licenseExpiry + ", type=" + type + "]";
	}
	
	
	
}
