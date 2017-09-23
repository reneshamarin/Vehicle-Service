package com.tutycarcare.service.beans;

import java.sql.Date;

public class Insurance {

	int id;
	String policyNum;
	String companyName;
	Date expiryDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPolicyNum() {
		return policyNum;
	}
	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Insurance [id=" + id + ", policyNum=" + policyNum + ", companyName=" + companyName + ", expiryDate="
				+ expiryDate + "]";
	}
	
}
