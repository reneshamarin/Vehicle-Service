package com.tutycarcare.service.backend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.tutycarcare.service.beans.Customer;

@Mapper
public interface CustomerMapper {
	
	
	@Insert("insert into customer(firstname, middlename, lastname, licence_number, licence_expiry, address1, address2, city, dob, type, mobile, alternate_number, email) values (#{firstname}, #{middlename}, #{lastname}, #{licenceNumber}, #{licenceExpiry}, #{address1}, #{address2}, #{city}, #{dob}, #{type}, #{mobile}, #{alternateNumber}, #{email})")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	boolean addCustomer(Customer customer);

}
