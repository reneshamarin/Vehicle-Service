package com.tutycarcare.service.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tutycarcare.service.backend.constants.MapperParameterConstants;
import com.tutycarcare.service.beans.Insurance;
import com.tutycarcare.service.beans.Job;
import com.tutycarcare.service.beans.JobLineItem;
import com.tutycarcare.service.beans.Service;
import com.tutycarcare.service.beans.Vehicle;
import com.tutycarcare.service.beans.VehicleBrand;
import com.tutycarcare.service.beans.VehicleModel;
import com.tutycarcare.service.beans.VehicleType;


@Mapper
public interface VehicleMapper {

	@Insert("insert into insurance(policy_num, company_name, expiry_date) values (#{policyNum}, #{companyName}, #{expiryDate})")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	boolean addInsurance(Insurance insurance);

	
	@Insert("insert into vehicle(registration_number, insurance_id, model_id) values (#{registrationNumber}, #{insurance.id}, #{vehicleType.modelId})")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	boolean addVehicle(Vehicle vehicle);
	
	@Select("select * from brand")
	List<VehicleBrand> getVehicleBrands();


	@Select("select * from model where brand_id = #{brandId}")
	List<VehicleModel> getVehicleModels(int brandId);

	@Insert("insert into model(name, description, active) values (#{name}, #{description}, true)")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	boolean addVehicleModel(VehicleModel vehicleModel);


	@Select("select * from vehicle")
	@Results({
		@Result (column="model_id", property="vehicleType", one= @One(select="getVehicleType"))
	})
	List<Vehicle> getVehicles();

	@Select("select m.id as model_id, m.name as model, b.id as brand_id, b.name as brand, t.id as type_id, t.name as type from model m join brand b on m.brand_id = b.id join type t on m.type_id = t.id")
	VehicleType getVehicleType(int modelId);

	@Insert("insert into job (vehicle_id, in_time, estimated_delivery, status, estimated_cost) values (#{job.vehicleId}, #{job.inTime}, #{job.estimatedDelivery}, #{job.status}, #{job.estimatedCost} )")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="job.id")
	boolean addJob(@Param(MapperParameterConstants.JOB) Job job);

	@Update("update job set estimated_delivery=#{job.estimatedDelivery}, out_time=#{job.outTime} where id=#{job.id}")
	boolean updateJob(@Param(MapperParameterConstants.JOB) Job job);


	@Insert("<script> insert into job_line_items(job_id, service_id, description, estimated_cost) values"
			+ "<foreach collection='jobLineItems' item='joblineItem' index='index'> (#{jobId}, #{joblineItem.serviceId}, #{joblineItem.description}, #{joblineItem.estimatedCost}) "
			+ "<if test=' jobLineItems.size()-1 > index'>,</if>"
			+ "</foreach>"
			+ "</script>")
	boolean addJobLineItems(@Param(MapperParameterConstants.JOB_LINE_ITEMS) List<JobLineItem> jobLineItems, @Param(MapperParameterConstants.JOB_ID) int jobId);

	@Select("select * from service")
	List<Service> getServices();

	@Select("select * from job")
	@Results({
		@Result(column="vehicle_id", property="vehicleId"),
		@Result(column="vehicle_id", property="vehicle", one=@One(select="getVehicleById"))
	})
	List<Job> getJobs();
	
	@Select("select * from vehicle where id=#{vehicleId}")
	Vehicle getVehicleById(int vehicleId);
}
