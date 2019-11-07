package com.rto.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rto.entity.AddresDetailsEntity;
import com.rto.entity.OwnerDetailsEntity;
import com.rto.entity.VehicleDetailsEntity;
import com.rto.model.VehicleRegistrationModel;
import com.rto.service.VehicleRegistrationService;
/**
 * This is VehicleRegistrationSummary controller class
 *It containes GET ,Post and Previous  method to launch form
 * @author bhupalp
 */
@Controller
public class VehicleRegistrationSummary {

	/**
	 * This is Used to inject VehicleRegistrationService to current class
	 */
	@Autowired
	private VehicleRegistrationService registerService;
	static Logger logger=Logger.getLogger(VehicleRegistrationSummary.class);
	/**
	 * Get method Execution
	 * @param model-store form data
	 * @return -SummaryRegistration form with all form data
	 */
	@RequestMapping(value = "/registration.htm")
	public String vregForm(Model model) {
		logger.debug("VehicleRegistration Details GET Methode Execution Started");
		logger.info("Entity class Object Created owner,vehicle,address");
        OwnerDetailsEntity ownerData=null;
		VehicleDetailsEntity vehicleData=null;
		AddresDetailsEntity addressData=null;
		//model class object
       VehicleRegistrationModel vrs=new VehicleRegistrationModel();
       logger.info("Invoke Service methode To get Data ");
       ownerData=registerService.getOwnerDetails();
       vehicleData=registerService.getVehicleDataById();
       addressData=registerService.getAddressDataById();
       logger.info("OwnerData "+ownerData);
       logger.info("vehicleData "+vehicleData);
       logger.info("addressData "+addressData);
       logger.debug("Set To Model Addtrinute");
       model.addAttribute("ownerData",ownerData);
       model.addAttribute("vehicleData",vehicleData);
       model.addAttribute("addressData",addressData);
       model.addAttribute("register",vrs);
		logger.debug("VehicleRegistration Details GET Methode Execution Completed And Return SummaryForm");
		return "v_registration";
	}
	
	/**
	 * Post Method execution 
	 * @param registerModel
	 * @param model
	 * @return-return Success message with VehicleRegistrationNumber generated.
	 */
	@RequestMapping(value ="/registration1.htm",method = RequestMethod.POST)
	public String registerVechNo(@ModelAttribute("register")VehicleRegistrationModel registerModel,Model model) {
		logger.debug("VehicleRegistration Details POST Methode Execution Started");
		String result=null;
		//invoke service
		String regNo=registerService.saveRegisterNo(registerModel);  
		logger.info("OwnerVehicleReistration Number "+regNo);
		if(regNo!=null) {
			 logger.debug("If condition Execution And Registration Success Return ");
			result="Congrats Your Registration SuccessFully";
		}
		else {
			logger.debug("Else condition Execution and Failed Registration");
			 result="Registration Failed...";
		}
		logger.debug("Set To Model Attribute");
		model.addAttribute("registrationNo",regNo);
		model.addAttribute("msg",result);
		logger.debug("VehicleRegistration Details POST Methode Execution Completed and return Success Form with Registration Number");
		return "regi_success";
	}
	
	/**
	 * Previous method Execution to Display AddressForm and for modify also we can do
	 * @param model
	 * @param req-to get addressId
	 * @return-addressDetails form page with data for modifying data.
	 */
	@RequestMapping(value = "/previousAddress.htm")
	public String previousAddress(Model model,HttpServletRequest req) {
		logger.debug("Previous Method Execution Started");
		//get addressId
		String addrId=req.getParameter("addrId");
	     logger.info("AddressDetails Id in Previous Method"+addrId);
		 logger.debug("Previous Method Execution Completed and Return AddressDetails Form");
		return "redirect:/address.htm?addrId="+addrId;
	}
	
}
