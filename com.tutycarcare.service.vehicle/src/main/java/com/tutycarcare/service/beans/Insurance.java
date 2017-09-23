package com.tutycarcare.service.beans;

import java.sql.Date;

public class Insurance {

	String policyNo;
	String companyName;
	Date expiryDate;
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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
		return "Insurance [policyNo=" + policyNo + ", companyName=" + companyName + "]";
	}
	
}
