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

import com.fleet.thieuduong.fleetapp.models.VehicleType;
import com.fleet.thieuduong.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {
	@Autowired
	private VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicletypes")
	public String getVehicleTypes(Model model) {
		model.addAttribute("vehicletypes", vehicleTypeService.getVehicleType());
		return "VehicleType";
	}

	@PostMapping("/vehicletype/addNew")
	public String addNewVehicleType(VehicleType vehicleType) {
		vehicleTypeService.saveVehicleType(vehicleType);
		return "redirect:/vehicletypes";
	}

	@RequestMapping("/vehicletype/findById")
	@ResponseBody
	public Optional<VehicleType> getVehicleTypeById(int id) {
		return vehicleTypeService.getVehicleTypeById(id);
	}

	@RequestMapping(value = "/vehicletype/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicleType(VehicleType vehicleType) {
		vehicleTypeService.saveVehicleType(vehicleType);
		return "redirect:/vehicletypes";
	}

	@RequestMapping(value = "/vehicletype/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicleType(int id) {
		vehicleTypeService.deleteVehicleType(id);
		return "redirect:/vehicletypes";
	}
}
