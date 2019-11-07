package com.rto.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.entity.AddresDetailsEntity;
import com.rto.model.AddresDetailsModel;
import com.rto.service.VehicleRegistrationService;
/**
 * This is AddressDetails controller class
 *It containes GET,Post and Previous method to launch form
 * @author bhupalp
 */
@Controller
public class AddressDetails {

	/**
	 * This is Used to inject VehicleRegistrationService to current class
	 */
	@Autowired
	private VehicleRegistrationService vehicleService;
	 /**
	   * use to store addressId to global
	   */
	String addrId;
  
	static Logger logger=Logger.getLogger(AddressDetails.class);

	
	/**
	 * Get method Execution
	 * @param model-used to store form data
	 * @param req- to get addressId from model class
	 * @return-return SummaryRegistration form
	 */
	@RequestMapping(value = "/address.htm")
	public String showAForm(Model model,HttpServletRequest req) {
		logger.debug("Address Details GET Methode Execution Started");
		// model class object
		AddresDetailsModel adm = new AddresDetailsModel();
		//get addrId
		addrId=req.getParameter("addrId");
      logger.info("AddressDetails"+addrId);
		if(addrId!=null && !addrId.equals("")){
			logger.debug("If Condition Execution Started");
			AddresDetailsEntity addrEntity=vehicleService.getAddressDetailsByAddrId(Integer.parseInt(addrId));
            logger.info("AddressDetails in If"+addrEntity);
			BeanUtils.copyProperties(addrEntity, adm);
		    model.addAttribute("addrdata",adm);
		    logger.debug("If Condition Execution Completed");
		}
		else {
			logger.debug("Else Execution Started");
		   model.addAttribute("addrdata", adm);
		   logger.debug("Else Execution Completed");
		}
		logger.debug("Address Details GET Methode Execution Started");
		return "a_details";
	}
	/**
	 * Post method execution started.
	 * @param rd-forwarding data to JSP page
	 * @param addressModel-use to store form data in model class
	 * @param model
	 * @return -launch VehicleRegistrationDetails form page and VehicleRegistrationDetails.java Get method executed
	 */
	@RequestMapping(value = "/address1.htm", method = RequestMethod.POST)
	public String registerAddress(RedirectAttributes rd,@ModelAttribute("addrdata") AddresDetailsModel addressModel, Model model) {
		 logger.debug("AddressDetails Register POST method Execution Started");
	      logger.info("AddressId in POST Method" +addrId);
		 if(addrId!=null){
			 logger.debug("If condition Execution And SetId");
			addressModel.setAddrId(Integer.parseInt(addrId));
		}
		// invoke method
		Integer adr_Id = vehicleService.saveAddressDetails(addressModel);
		//model.addAttribute("msg", result);
		 logger.debug("To Redirect addrId To Next Jsp Page");
		rd.addFlashAttribute("addrId",adr_Id);
		logger.debug("VehicleDetails Register POST method Execution Completed");
		return "redirect:/registration.htm";
	}


	/**
	 * This method is used to came to previous page when enter previous button and Execute return to VehicleDetails 
	 * Get method with data display.
	 * It will go back on the basis of vehicleId. 
	 * return i.e redirect vehicleDetails Form is launched with data.
	 * redirect:/vehicle.htm?vehicleId=
	 */
	@RequestMapping(value = "/previousVehicle.htm")
	public String previousVehicle(Model model,@ModelAttribute("addrdata") AddresDetailsModel addressModel,HttpServletRequest req) {
		   logger.debug("Previous Method Execution Started");
	     String vehicleId=req.getParameter("vehicleId");
	     logger.info("VehilceDetails Id in Previous Method"+vehicleId);
		 logger.debug("Previous Method Execution Completed and Return VehicleDetails Form");
	     return "redirect:/vehicle.htm?vehicleId="+vehicleId;
	}
}
