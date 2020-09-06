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

import com.fleet.thieuduong.fleetapp.models.VehicleMaintenance;
import com.fleet.thieuduong.fleetapp.services.SupplierService;
import com.fleet.thieuduong.fleetapp.services.VehicleMaintenanceService;
import com.fleet.thieuduong.fleetapp.services.VehicleService;

@Controller
public class VehicleMaintenanceController {
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehiclemaintenances")
	public String getVehicleMaintenances(Model model) {
		System.out.println(vehicleMaintenanceService.getVehicleMaintenances());
		model.addAttribute("maintenances", vehicleMaintenanceService.getVehicleMaintenances());
		model.addAttribute("suppliers", supplierService.getSuppliers());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		return "VehicleMaintenance";
	}

	@PostMapping("/vehiclemaintenance/addNew")
	public String addNewVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.saveVehicleMaintenance(vehicleMaintenance);
		return "redirect:/vehiclemaintenances";
	}

	@RequestMapping("/vehiclemaintenance/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> getVehicleMaintenanceById(int id) {
		return vehicleMaintenanceService.getVehicleMaintenanceById(id);
	}

	@RequestMapping(value = "/vehiclemaintenance/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.saveVehicleMaintenance(vehicleMaintenance);
		return "redirect:/vehiclemaintenances";
	}

	@RequestMapping(value = "/vehiclemaintenance/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicleMaintenance(int id) {
		vehicleMaintenanceService.deleteVehicleMaintenance(id);
		return "redirect:/vehiclemaintenances";
	}
}
