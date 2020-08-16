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
import com.fleet.thieuduong.fleetapp.models.Employee;
import com.fleet.thieuduong.fleetapp.services.CountryService;
import com.fleet.thieuduong.fleetapp.services.EmployeeService;
import com.fleet.thieuduong.fleetapp.services.EmployeeTypeService;
import com.fleet.thieuduong.fleetapp.services.JobTitleService;
import com.fleet.thieuduong.fleetapp.services.StateService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@Autowired
	private JobTitleService jobTitleService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;

	@GetMapping("/employees")
	public String getEmployees(Model model) {
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("employeetypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("jobtitles", jobTitleService.getJobTitles());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		return "Employee";
	}

	@PostMapping(value="/employee/addNew")
	public String addNewEmployee(Employee employee) {
		System.out.println("employee photo: " + employee.getPhoto());
//		System.out.println("multipartFile: " + multipartFile);
//		employeeService.saveEmployee(employee);
//		try {
//			filesStorageService.save(multipartFile);
//		} catch (Exception e) {
//			System.err.println("Cannot save file");;
//		}
		return "redirect:/employees";
	}

	@RequestMapping("/employee/findById")
	@ResponseBody
	public Optional<Employee> getEmployeeById(int id) {
		return employeeService.getEmployeeById(id);
	}

	@RequestMapping(value = "/employee/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateEmployee(Employee Employee) {
		employeeService.saveEmployee(Employee);
		return "redirect:/employees";
	}

	@RequestMapping(value = "/employee/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteEmployee(int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
}
