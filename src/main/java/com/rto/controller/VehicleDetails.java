package com.rto.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.rto.entity.VehicleDetailsEntity;
import com.rto.model.VehicleDetailsModel;
import com.rto.service.VehicleRegistrationService;
/**
 * This is VehicleDetails controller class
 *It containes GET ,Post and Previous  method to launch form
 * @author bhupalp
 */
@Controller
public class VehicleDetails {
	/**
	 * This is Used to inject VehicleRegistrationService to current class
	 */
	
	@Autowired
	private VehicleRegistrationService vehicleService;
 
	static Logger logger=Logger.getLogger(VehicleDetails.class);
	  /**
	   * use to store vehicleId to global
	   */
	 String vehicleId;
	
	 /**
	  * Get Method Execution Started
	  * @param model
	  * @param req use to get vehicleId
	  * @return launching vehicleDetails jsp page
	  */
	@RequestMapping(value = "/vehicle.htm")
	public String showVForm(Model model,HttpServletRequest req) {
		logger.debug("--Vehicle  Details GET Methode Execution Started--");
		VehicleDetailsModel vdm = new VehicleDetailsModel();
		vehicleId=req.getParameter("vehicleId");
		if(vehicleId!=null && !vehicleId.equals("")) {
			logger.debug("If Condition Execution Started");
			VehicleDetailsEntity vdEntity=vehicleService.getVehicleDetailsByVid(Integer.parseInt(vehicleId));
			logger.info("VehicleDetailsEntity"+vdEntity);
			BeanUtils.copyProperties(vdEntity, vdm);
			model.addAttribute("vehicledata", vdm);	
			logger.debug("If Condition Execution Completed");
		}
		else {
			logger.debug("Else Execution Started");
		model.addAttribute("vehicledata", vdm);
		logger.debug("Else Execution Completed");
		}
		logger.info("Vehicle All list Is Loaded");
		vehicleList(model);
		logger.debug("--Vehicle  Details GET Methode Execution Completed--");
		return "v_details";
	}

	/**
	 * Post method execution started.
	 * @param rd-forwarding data to JSP page
	 * @param vehicleModel-use to store form data in model class
	 * @param model
	 * @return -launch addressDetails form page and AddressDetails.java Get method executed
	 */
	@RequestMapping(value = "/vehicle1.htm", method = RequestMethod.POST)
	public String registerVDetails(RedirectAttributes rd,@ModelAttribute("vehicledata") VehicleDetailsModel vehicleModel, Model model) {
        logger.debug("VehicleDetails Register POST method Execution Started");
		//set ownerid in vehicleDetailsModel class
        logger.info("VehicleId in POST Method" +vehicleId);
        if(vehicleId!=null) {
        	  logger.debug("If condition Execution And SetId");
			  vehicleModel.setVehicleId(Integer.parseInt(vehicleId));
		  }
		// invoke service method
		Integer v_id = vehicleService.saveVehicleDetails(vehicleModel);
		//Integer ownerId=vehicleService.saveVehicleDetails(vehicleModel);
        logger.debug("To Redirect ownerId To Next Jsp Page");
		rd.addFlashAttribute("vehicleId",v_id);
		logger.debug("VehicleDetails Register POST method Execution Completed");
		return "redirect:/address.htm";
	}
	
	/**
	 * This method is used to came to previous page when enter previous button and Execute return to OwnerDetails 
	 * Get method with data display.
	 * It will go back on the basis of ownerId. 
	 * return i.e redirect ownerDetails Form is launched with data.
	 */
	@RequestMapping(value = "/previousOwner")
	public String previousOwnerDetail(Model model,@ModelAttribute("vehicledata") VehicleDetailsModel vehicleModel,HttpServletRequest req){
	    logger.debug("Previous Method Execution Started");
		String ownerId=req.getParameter("ownerId");
		 logger.info("OwnerDetails Id in Previous Method"+ownerId);
		 logger.debug("Previous Method Execution Completed and Return OwnerDetails Form");
		return "redirect:/owner.htm?ownerId="+ownerId;
	}

	/**
	 * 
	 * @param model-used to store all data in modelAttribute.
	 * @return-vehicleDetails form page with this data.
	 * and this Method is called from Get method to display data.
	 * 
	 */
	public String vehicleList(Model model) {
		List<String> list = new ArrayList<>();
		list.add("2-Wheeler");
		list.add("4-Wheeler");
		list.add("6-Wheeler");
		list.add("8-Wheeler");
		model.addAttribute("vehiclelist", list);
		return "v_details";

	}
}
