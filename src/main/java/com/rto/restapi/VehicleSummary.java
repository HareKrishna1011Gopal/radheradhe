package com.rto.restapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.rto.entity.AddresDetailsEntity;
import com.rto.entity.OwnerDetailsEntity;
import com.rto.entity.VehicleDetailsEntity;
import com.rto.entity.VehicleRegistrationEntity;

import lombok.Data;

@Data
@XmlRootElement(name = "VehicleSummary")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleSummary {

	  private OwnerDetailsEntity ownerEntity;
	  private VehicleDetailsEntity vehicleEntity;
	  private AddresDetailsEntity addressEntity;
	  private VehicleRegistrationEntity registrationEntity;
}
