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

import com.fleet.thieuduong.fleetapp.models.Vehicle;
import com.fleet.thieuduong.fleetapp.services.EmployeeService;
import com.fleet.thieuduong.fleetapp.services.LocationService;
import com.fleet.thieuduong.fleetapp.services.VehicleMakeService;
import com.fleet.thieuduong.fleetapp.services.VehicleModelService;
import com.fleet.thieuduong.fleetapp.services.VehicleService;
import com.fleet.thieuduong.fleetapp.services.VehicleStatusService;
import com.fleet.thieuduong.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@Autowired
	private VehicleModelService vehicleModelService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private LocationService locationService;

	@GetMapping("/vehicles")
	public String getVehicles(Model model) {
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("vehicletypes", vehicleTypeService.getVehicleType());
		model.addAttribute("vehiclemakes", vehicleMakeService.getVehicleMake());
		model.addAttribute("vehiclestatuses", vehicleStatusService.getVehicleStatus());
		model.addAttribute("vehiclemodels", vehicleModelService.getVehicleModel());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("locations", locationService.getLocations());
		return "Vehicle";
	}

	@PostMapping("/vehicle/addNew")
	public String addNewVehicle(Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicles";
	}

	@RequestMapping("/vehicle/findById")
	@ResponseBody
	public Optional<Vehicle> getVehicleById(int id) {
		return vehicleService.getVehicleById(id);
	}

	@RequestMapping(value = "/vehicle/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicle(Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicles";
	}

	@RequestMapping(value = "/vehicle/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicle(int id) {
		vehicleService.deleteVehicle(id);
		return "redirect:/vehicles";
	}
}
