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

import com.fleet.thieuduong.fleetapp.models.VehicleStatus;
import com.fleet.thieuduong.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	@Autowired
	private VehicleStatusService vehicleStatusService;

	@GetMapping("/vehiclestatuses")
	public String getVehicleStatuses(Model model) {
		model.addAttribute("vehiclestatuses", vehicleStatusService.getVehicleStatus());
		return "VehicleStatus";
	}

	@PostMapping("/vehiclestatus/addNew")
	public String addNewVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusService.saveVehicleStatus(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}

	@RequestMapping("/vehiclestatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> getVehicleStatusById(int id) {
		return vehicleStatusService.getVehicleStatusById(id);
	}

	@RequestMapping(value = "/vehiclestatus/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusService.saveVehicleStatus(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}

	@RequestMapping(value = "/vehiclestatus/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicleStatus(int id) {
		vehicleStatusService.deleteVehicleStatus(id);
		return "redirect:/vehiclestatuses";
	}
}
