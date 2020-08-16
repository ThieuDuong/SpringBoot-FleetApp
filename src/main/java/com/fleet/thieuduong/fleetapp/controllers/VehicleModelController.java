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

import com.fleet.thieuduong.fleetapp.models.VehicleModel;
import com.fleet.thieuduong.fleetapp.services.VehicleModelService;

@Controller
public class VehicleModelController {
	@Autowired
	private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehiclemodels")
	public String getVehicleModels(Model model) {
		model.addAttribute("vehiclemodels", vehicleModelService.getVehicleModel());
		return "VehicleModel";
	}
	
	@PostMapping("/vehiclemodel/addNew")
	public String addNewVehicleModel(VehicleModel vehicleModel) {
		vehicleModelService.saveVehicleModel(vehicleModel);
		return "redirect:/vehiclemodels";
	}
	
	@RequestMapping("/vehiclemodel/findById")
	@ResponseBody
	public Optional<VehicleModel> getVehicleModelById(int id) {
		return vehicleModelService.getVehicleModelById(id);
	}
	
	@RequestMapping(value="/vehiclemodel/edit", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleModel(VehicleModel vehicleModel){
		vehicleModelService.saveVehicleModel(vehicleModel);
		return "redirect:/vehiclemodels";
	}
	
	@RequestMapping(value="/vehiclemodel/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleModel(int id){
		vehicleModelService.deleteVehicleModel(id);
		return "redirect:/vehiclemodels";
	}
}
