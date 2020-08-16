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

import com.fleet.thieuduong.fleetapp.models.EmployeeType;
import com.fleet.thieuduong.fleetapp.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {
	@Autowired
	private EmployeeTypeService employeeTypeService;

	@GetMapping("/employeetypes")
	public String getEmployeeTypees(Model model) {
		model.addAttribute("employeetypes", employeeTypeService.getEmployeeTypes());
		return "EmployeeType";
	}

	@PostMapping("/employeetype/addNew")
	public String addNewEmployeeType(EmployeeType employeeType) {
		employeeTypeService.saveEmployeeType(employeeType);
		return "redirect:/employeetypes";
	}

	@RequestMapping("/employeetype/findById")
	@ResponseBody
	public Optional<EmployeeType> getEmployeeTypeById(int id) {
		return employeeTypeService.getEmployeeTypeById(id);
	}

	@RequestMapping(value = "/employeetype/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateEmployeeType(EmployeeType employeeType) {
		employeeTypeService.saveEmployeeType(employeeType);
		return "redirect:/employeetypes";
	}

	@RequestMapping(value = "/employeetype/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteEmployeeType(int id) {
		employeeTypeService.deleteEmployeeType(id);
		return "redirect:/employeetypes";
	}
}
