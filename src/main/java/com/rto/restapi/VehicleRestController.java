package com.rto.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rto.service.VehicleRegistrationService;

@RestController
public class VehicleRestController {

	@Autowired
	private VehicleRegistrationService service;
	
	@GetMapping(value = {"/rest"},produces = {"application/xml","application/json"})
	public VehicleSummary getAllDetails(@RequestParam("regNo") String regNo) {
		System.out.println("VehicleRestController.getAllDetails()");
		return service.getAllDetailsByRegNo(regNo);
	}
}
