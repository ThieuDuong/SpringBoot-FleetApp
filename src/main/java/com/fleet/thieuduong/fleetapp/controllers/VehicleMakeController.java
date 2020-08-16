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

import com.fleet.thieuduong.fleetapp.models.VehicleMake;
import com.fleet.thieuduong.fleetapp.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@GetMapping("/vehiclemakes")
	public String getVehicleMakes(Model model) {
		model.addAttribute("vehiclemakes", vehicleMakeService.getVehicleMake());
		return "VehicleMake";
	}
	
	@PostMapping("/vehiclemake/addNew")
	public String addNewVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeService.saveVehicleMake(vehicleMake);
		return "redirect:/vehiclemakes";
	}
	
	@RequestMapping("/vehiclemake/findById")
	@ResponseBody
	public Optional<VehicleMake> getVehicleMakeById(int id) {
		return vehicleMakeService.getVehicleMakeById(id);
	}
	
	@RequestMapping(value="/vehiclemake/edit", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMake(VehicleMake vehicleMake){
		vehicleMakeService.saveVehicleMake(vehicleMake);
		return "redirect:/vehiclemakes";
	}
	
	@RequestMapping(value="/vehiclemake/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleMake(int id){
		vehicleMakeService.deleteVehicleMake(id);
		return "redirect:/vehiclemakes";
	}
}
