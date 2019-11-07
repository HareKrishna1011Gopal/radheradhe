package com.rto.model;

import lombok.Data;
/**
 * This is VehicleDetailsModel pojo class used to store form data
 * @author bhupalp
 *
 */
@Data
public class VehicleDetailsModel{
	 private Integer vehicleId; 
     private String vtype;
     private String model;
     private String vname;
}
