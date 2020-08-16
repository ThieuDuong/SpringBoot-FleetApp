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

import com.fleet.thieuduong.fleetapp.models.VehicleHire;
import com.fleet.thieuduong.fleetapp.services.ClientService;
import com.fleet.thieuduong.fleetapp.services.LocationService;
import com.fleet.thieuduong.fleetapp.services.VehicleHireService;
import com.fleet.thieuduong.fleetapp.services.VehicleService;

@Controller
public class VehicleHireController {
	@Autowired
	private VehicleHireService vehicleHireService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LocationService locationService;

	@GetMapping("/vehiclehires")
	public String getVehicleHirees(Model model) {
		model.addAttribute("vehiclehires", vehicleHireService.getVehicleHires());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("locations", locationService.getLocations());
		return "VehicleHire";
	}

	@PostMapping("/vehiclehire/addNew")
	public String addNewVehicleHire(VehicleHire vehicleHire) {
		vehicleHireService.saveVehicleHire(vehicleHire);
		return "redirect:/vehiclehires";
	}

	@RequestMapping("/vehiclehire/findById")
	@ResponseBody
	public Optional<VehicleHire> getVehicleHireById(int id) {
		return vehicleHireService.getVehicleHireById(id);
	}

	@RequestMapping(value = "/vehiclehire/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicleHire(VehicleHire vehicleHire) {
		vehicleHireService.saveVehicleHire(vehicleHire);
		return "redirect:/vehiclehires";
	}

	@RequestMapping(value = "/vehiclehire/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicleHire(int id) {
		vehicleHireService.deleteVehicleHire(id);
		return "redirect:/vehiclehires";
	}

}
