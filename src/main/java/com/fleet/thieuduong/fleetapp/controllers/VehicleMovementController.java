package com.fleet.thieuduong.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.thieuduong.fleetapp.models.VehicleMovement;
import com.fleet.thieuduong.fleetapp.services.LocationService;
import com.fleet.thieuduong.fleetapp.services.VehicleMovementService;
import com.fleet.thieuduong.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController {
	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private LocationService locationService;

	@GetMapping("/vehiclemovements")
	public String getVehicleMovementes(Model model) {
		model.addAttribute("vehiclemovements", vehicleMovementService.getVehicleMovement());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("locations", locationService.getLocations());
		return "VehicleMovement";
	}

	@PostMapping("/vehiclemovement/addNew")
	public String addNewVehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementService.saveVehicleMovement(vehicleMovement);
		return "redirect:/vehiclemovements";
	}

	@RequestMapping("/vehiclemovement/findById")
	@ResponseBody
	public Optional<VehicleMovement> getVehicleMovementById(int id) {
		return vehicleMovementService.getVehicleMovementById(id);
	}

	@RequestMapping(value = "/vehiclemovement/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementService.saveVehicleMovement(vehicleMovement);
		return "redirect:/vehiclemovements";
	}

	@RequestMapping(value = "/vehiclemovement/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicleMovement(int id) {
		vehicleMovementService.deleteVehicleMovement(id);
		return "redirect:/vehiclemovements";
	}

}
