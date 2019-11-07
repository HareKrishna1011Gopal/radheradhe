package com.rto.service;
import com.rto.entity.AddresDetailsEntity;
import com.rto.entity.OwnerDetailsEntity;
import com.rto.entity.VehicleDetailsEntity;
import com.rto.model.AddresDetailsModel;
import com.rto.model.OwnerDetailsModel;
import com.rto.model.VehicleDetailsModel;
import com.rto.model.VehicleRegistrationModel;
import com.rto.restapi.VehicleSummary;
/**
 * This is Interface Vehicleregistration talk to VehcileRegistrationService class
 * @author bhupalp
 *
 */
public interface VehicleRegistrationService {

	 public Integer saveOwnerDetails(OwnerDetailsModel ownerModel);
	 public Integer saveVehicleDetails(VehicleDetailsModel vehicleModel);
	 public Integer saveAddressDetails(AddresDetailsModel addressModel);
	 public String saveRegisterNo(VehicleRegistrationModel registerModel);
	 public VehicleSummary getAllDetailsByRegNo(String regNo);
	 public OwnerDetailsEntity getOwnerDetailsById(Integer oid);
	 public VehicleDetailsEntity getVehicleDetailsByVid(Integer vehicleId);
	 public AddresDetailsEntity getAddressDetailsByAddrId(Integer addrId);
	 public OwnerDetailsEntity getOwnerDetails();
	 public VehicleDetailsEntity getVehicleDataById();
	 public AddresDetailsEntity getAddressDataById();
}
