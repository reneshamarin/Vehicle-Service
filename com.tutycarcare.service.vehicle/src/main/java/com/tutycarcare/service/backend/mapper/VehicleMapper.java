package com.tutycarcare.service.backend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.tutycarcare.service.beans.Insurance;
import com.tutycarcare.service.beans.Vehicle;

@Mapper
public interface VehicleMapper {

	@Insert("insert into insurance(policy_num, company_name, expiry_date) values (#{policyNum}, #{companyName}, #{expiryDate})")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	boolean addInsurance(Insurance insurance);

	
	@Insert("insert into vehicle(registration_number, insurance_id, model_id) values (#{registrationNumber}, #{insurance.id}, #{vehicleType.modelId})")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	boolean addVehicle(Vehicle vehicle);

}
