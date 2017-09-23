package com.tutycarcare.service.beans;

import java.sql.Date;

public class Customer {

	String firstname;
	String middlename;
	String lastname;
	String address1;
	String address2;
	String city;
	String mobile;
	String alternateNumber;
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
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
				+ ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", mobile=" + mobile
				+ ", alternateNumber=" + alternateNumber + ", email=" + email + ", dob=" + dob + ", dom=" + dom
				+ ", licenseNumber=" + licenseNumber + ", licenseExpiry=" + licenseExpiry + ", type=" + type + "]";
	}	
	
}
