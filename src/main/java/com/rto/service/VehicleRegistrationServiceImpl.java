package com.rto.service;

import java.util.Optional;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entity.AddresDetailsEntity;
import com.rto.entity.OwnerDetailsEntity;
import com.rto.entity.VehicleDetailsEntity;
import com.rto.entity.VehicleRegistrationEntity;
import com.rto.model.AddresDetailsModel;
import com.rto.model.OwnerDetailsModel;
import com.rto.model.VehicleDetailsModel;
import com.rto.model.VehicleRegistrationModel;
import com.rto.repo.AddressRepository;
import com.rto.repo.OwnerRepository;
import com.rto.repo.VechRegistrationRepository;
import com.rto.repo.VehicleRepository;
import com.rto.restapi.VehicleSummary;

@Service("/service")
public class VehicleRegistrationServiceImpl implements VehicleRegistrationService {
	/**
	 * This is used to get Logger Object for current class
	 */
	
	static Logger logger=Logger.getLogger(VehicleRegistrationServiceImpl.class);
	
    /**
     * used to inject ownerRepository
     */
	@Autowired
	private OwnerRepository ownerRepo;
	/**
     * used to inject vehicleRepository
     */
	@Autowired
	private VehicleRepository vehicleRepo;
	/**
     * used to inject addressRepository
     */
	@Autowired
	private AddressRepository addrsRepo;
	/**
     * used to inject vregistrationRepository
     */
	@Autowired
	private VechRegistrationRepository regiRepo;

	/**
     * used to create global ownerEntity class i.e we can use in all method to get ownerId
     */
	private OwnerDetailsEntity ownerdetailsentity;

	/**
	 * This method used to save or register OwnerDetails in DB by invoke ownerRepository
	 * i.e using custome query
	 * and return OwnerId.
	 */
	@Override
	public Integer saveOwnerDetails(OwnerDetailsModel ownerModel) {
		logger.debug("Save ownerDetails Service Method Execution Started");
		ownerdetailsentity = new OwnerDetailsEntity();
		Integer ownerId=null;
		// copy model to entity
		BeanUtils.copyProperties(ownerModel, ownerdetailsentity);
		logger.info("Before Invoke ownerRepo "+ownerdetailsentity);
		// invoke repository
		OwnerDetailsEntity optEntity = ownerRepo.save(ownerdetailsentity);
		logger.info("After Invoke ownerRepo "+optEntity);
		if(optEntity.getOwnerId()!=null) {	
		 ownerId=optEntity.getOwnerId();
		 logger.debug("If Condition Execution "+ownerId);
		}
		else {
			ownerId=null;
			logger.debug("Else Condition Execution "+ownerId);
		}
		logger.debug("Save ownerDetails Service Method Execution Completed");
		return ownerId;
	}
	/**
	 * This method used to save or register vehicleDetails in DB by invoke vehicleRepository
	 * and store in vehicleEntity class
	 * i.e using custome query
	 * return vehicleId 
	 */
	@Override
	public Integer saveVehicleDetails(VehicleDetailsModel vehicleModel) {
		logger.debug("Save VehicleDetails Service Method Execution Started");
		VehicleDetailsEntity vehicleEntity = null;
		Integer v_Id=null;
		vehicleEntity = new VehicleDetailsEntity();
		// copy model to entity
		BeanUtils.copyProperties(vehicleModel, vehicleEntity);
		logger.info("Before Invoke vehilceRepo "+vehicleEntity);
		logger.info("Set ownerDetails To FK column");
		//set OwnerDetailsClass
		vehicleEntity.setOwnerdetailsentity(ownerdetailsentity);
		// invoke vehicleRepository
		VehicleDetailsEntity vEntity = vehicleRepo.save(vehicleEntity);
		logger.info("After Invoke vehicleRepo "+vEntity);
		if(vEntity.getVehicleId()!=null) {
		//get ownerId
		v_Id=vEntity.getVehicleId();
		 logger.debug("If Condition Execution "+v_Id);
		}
		else {
			v_Id=null;
			logger.debug("Else Condition Execution "+v_Id);
		}
		logger.debug("Save vehicleDetails Service Method Execution Completed");
		return v_Id;
		//return ownerId;
	}
	/**
	 * This method used to save or register AddressDetails in DB by invoke AddressRepository
	 * and store iAddressEntity
	 * i.e using custome query
	 * return addressId 
	 */
	@Override
	public Integer saveAddressDetails(AddresDetailsModel addressModel) {
		logger.debug("Save AddressDetails Service Method Execution Started");
		AddresDetailsEntity addressEntity = null;
		Integer adrId = null;
		addressEntity = new AddresDetailsEntity();
		// copy model to entity
		BeanUtils.copyProperties(addressModel, addressEntity);
		//set OwnerDetailsEntity
		logger.info("Set ownerDetails To FK column");
		addressEntity.setOwnerdetailsentity(ownerdetailsentity);
		// invoke vehicleRepository
		logger.info("After Invoke vehicleRepo "+addressEntity);
		AddresDetailsEntity addEntity = addrsRepo.save(addressEntity);
		logger.info("After Invoke vehicleRepo "+addEntity);
		if(addEntity.getAddrId()!=null) {
			//get addreId
			adrId=addEntity.getAddrId();
			logger.debug("If Condition Execution "+adrId);
		}else {
			adrId=null;
			logger.debug("Else Condition Execution "+adrId);
		}
		logger.debug("Save addressDetails Service Method Execution Completed");
		return adrId;
	}

   /**
    *This is used to save Registration Number in that RegistrationNumber is CustomeGenerated 
    *return registerNumber  
    */
	@Override
	public String saveRegisterNo(VehicleRegistrationModel registerModel) {
		logger.debug("Save vehicleRegistration Service Method EXecution Started");
		String randomRegNo = null;
		// entity class object
		VehicleRegistrationEntity entityRegi = new VehicleRegistrationEntity();
		// set to FK
		logger.info("Set ownerDetails To FK column");
		entityRegi.setOwnerdetailsentity(ownerdetailsentity);
		// generate randomNo and invoke method
		randomRegNo = generatRegistrationNo();
		logger.info("Random Number Generated and Set Entity class Property"+randomRegNo);
		// set randomNo
		entityRegi.setVregNumber(randomRegNo);
		// copy model to entity
		BeanUtils.copyProperties(registerModel, entityRegi);
		// invoke repo
		logger.info("Before Invoke vehilceRepo "+entityRegi);
		VehicleRegistrationEntity optEntity = regiRepo.save(entityRegi);
		logger.info("Before Invoke vehilceRepo "+optEntity);
		//return regNo
		logger.debug("Save vehicleRegistration Service Method EXecution Started and Return randomRegNumber.");
		return randomRegNo;
	}
     /**
      * used to generate registrationNumber by random 
      * @return return randomNumber to method
      */
	public static String generatRegistrationNo() {
		logger.debug("GenerationRegistration number Execution Started");
		Random random = new Random();
		int initial_2 = random.nextInt(100);
		System.out.println(initial_2);
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String randomString = "";

		char[] text = new char[4];
		for (int i = 0; i < 4; i++) {
			text[i] = chars.charAt(random.nextInt(chars.length()));
		}
		for (int i = 0; i < text.length; i++) {
			randomString = randomString + text[i];
		}
		int last_3 = random.nextInt(1000);
		logger.info("InitialCharss "+initial_2);
		logger.info("RandomString "+randomString);
		logger.info("LastChar "+last_3);
		String RegistrationNumber = initial_2 + randomString + last_3;
        logger.info("Registration Number Generate "+RegistrationNumber);
		logger.debug("GenerationRegistration number Execution Completed return Number");       
		return RegistrationNumber;
	}
	/**
	 * This used to get All Details in one class and store it i.e VehicleSummary.java class
	 * This used for RestApi to get data through RegisterNumber inn xml or json format
	 */
	@Override
	public VehicleSummary getAllDetailsByRegNo(String regNo) {
         logger.debug("Service VehicleSummaryAllDetails By RegisNo Execution Started");
		VehicleSummary summary = new VehicleSummary();
		Integer ownId = null;
		// get ownerId for rest through regNo
		logger.info("Registration Number "+regNo);
		VehicleRegistrationEntity regInfo = regiRepo.getOwnerIdForRest(regNo);
		// get OwnerId
		ownId = regInfo.getOwnerdetailsentity().getOwnerId();
		logger.info("Get All Entity Details  From DataBase");
		Optional<OwnerDetailsEntity> summaryEntity = ownerRepo.findById(ownId);
		OwnerDetailsEntity ownerEnt = summaryEntity.get();
		logger.info("Get All Entity Details  From DataBase By Using CustomQuery");
		VehicleDetailsEntity vehicleSummary = vehicleRepo.getAllDetailsById(ownId);
		AddresDetailsEntity addressSummary = addrsRepo.getAllDetailsById(ownId);
		VehicleRegistrationEntity regiSummary = regiRepo.getAllDetailsById(ownId);
		// set all to summary
		logger.info("Set To Summary Class");
		summary.setOwnerEntity(ownerEnt);
		summary.setVehicleEntity(vehicleSummary);
		summary.setAddressEntity(addressSummary);
		summary.setRegistrationEntity(regiSummary);
        logger.debug("Service VehicleSummaryAllDetails By RegisNo Execution Completed");
		return summary;
	}
    /**
     * This method used to getOwnerDetails by ownerId
     */
	@Override
	public OwnerDetailsEntity getOwnerDetailsById(Integer oid) {
	   logger.debug("Service OwnerDetails By ownerId Execution");
		Optional<OwnerDetailsEntity> optEntity=ownerRepo.findById(oid);
		OwnerDetailsEntity ownDetails=optEntity.get();
		return ownDetails;
	}

	/**
     * This method used to getVehicleDetails by vehicleId
     */
	@Override
	public VehicleDetailsEntity getVehicleDetailsByVid(Integer vehicleId) {
		   logger.debug("Service VehicleDetails By vehicleId Execution");		
        Optional<VehicleDetailsEntity> optVeEntity=vehicleRepo.findById(vehicleId);
        VehicleDetailsEntity vehDetails=optVeEntity.get();
		return vehDetails;
	}
	
    /**
     * This method used to getownerAddressDetails By addressId.
     */
	@Override
	public AddresDetailsEntity getAddressDetailsByAddrId(Integer addrId) {
		   logger.debug("Service AddressDetails By addressId Execution");
        Optional<AddresDetailsEntity> optEntity=addrsRepo.findById(addrId);
        AddresDetailsEntity addrEntity=optEntity.get();
		return addrEntity;
	}
    
	/**
	 * This method is used to getOwnerDetails by ownerId
	 * and return ownerData to vehcileRegistration.java class in GET method
	 */
	@Override
	public OwnerDetailsEntity getOwnerDetails() {
	    logger.debug("Service OwnerDetails get Data Execution");
        Optional<OwnerDetailsEntity> optEntity=ownerRepo.findById(ownerdetailsentity.getOwnerId());
        OwnerDetailsEntity ownerData=optEntity.get();
		return ownerData;
	}
	/**
	 * This method is used to getVehicleDetails by ownerId
	 * and return optEntity to vehcileRegistration.java class in GET method
	 */
	@Override
	public VehicleDetailsEntity getVehicleDataById() {
		 logger.debug("Service vehicleDetails get Data Execution");
 		return   vehicleRepo.getAllDetailsById(ownerdetailsentity.getOwnerId());
	}

	/**
	 * This method is used to getAddressDetails by ownerId
	 * and return addressData to vehcileRegistration.java class in GET method
	 */
	@Override
	public AddresDetailsEntity getAddressDataById() {
		logger.debug("Service AddressDetails get Data Execution");
		return addrsRepo.getAllDetailsById(ownerdetailsentity.getOwnerId());
	}
}
