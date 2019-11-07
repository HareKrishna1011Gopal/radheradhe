package com.rto.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.entity.OwnerDetailsEntity;
import com.rto.model.OwnerDetailsModel;
import com.rto.service.VehicleRegistrationService;
/**
 * This is OwnerDetails controller class
 *It containes GET and Post  method to launch form
 * @author bhupalp
 */
@Controller
public class OwnerDetails {
	/**
	 * This is Used to inject VehicleRegistrationService to current class
	 */
	
	@Autowired
	private VehicleRegistrationService vehicleService;
    
	/**
	 * This is used to get Logger Object for current class
	 */
	
	static Logger logger=Logger.getLogger(OwnerDetails.class);
	 String ownerId;
	
	 /**
	  * 
	  * @param model 
	  * @param req to get ownerId
	  * @return  owner details form page
	  */
	@RequestMapping(value = "/owner.htm")
	public String showOForm(Model model,HttpServletRequest req) {
		logger.debug("--OwnerDetails GET Methode Execution Started--");
		OwnerDetailsModel odm = new OwnerDetailsModel();
		ownerId=req.getParameter("ownerId");
		if(ownerId!=null && !ownerId.equals("")) {
       OwnerDetailsEntity ownDetails=vehicleService.getOwnerDetailsById(Integer.parseInt(ownerId));
       BeanUtils.copyProperties(ownDetails, odm);
       model.addAttribute("ownerdata",odm);
       logger.info("In if OwnerDetails"+ownDetails);
		}
		else {		
			model.addAttribute("ownerdata", odm);
			logger.info("Else Model data with Null");
		}
		logger.debug("--OwnerDetails GET Methode Execution Completed--");
		return "o_details";
	}

	/**
	 * Post method execution 
	 * @param adtr  used to Redirect Attribute to JSP page
	 * @param ownerModel
	 * @param model 
	 * @return String
	 */
	
	@RequestMapping(value = "/owner1.htm", method = RequestMethod.POST)
	public String registerOwnerDetails(RedirectAttributes adtr,@ModelAttribute("ownerdata") OwnerDetailsModel ownerModel, Model model) {
		logger.debug(" OwnerDetails Register Post Methode Execution Started");
		//set oid 
		if(ownerId!=null) {
			logger.info("OwnerId for set"+ownerId);
			ownerModel.setOwnerId(Integer.parseInt(ownerId));
		}
		// invoke service method
         Integer ow_id=vehicleService.saveOwnerDetails(ownerModel);
		// set in model attribute
         logger.debug("To Redirect ownerId To Next Jsp Page");
         adtr.addFlashAttribute("ownerId",ow_id);
         logger.debug(" OwnerDetails Register Post Methode Execution Completed");
		return "redirect:/vehicle.htm";
	}
}
