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

import com.fleet.thieuduong.fleetapp.models.Supplier;
import com.fleet.thieuduong.fleetapp.services.CountryService;
import com.fleet.thieuduong.fleetapp.services.StateService;
import com.fleet.thieuduong.fleetapp.services.SupplierService;

@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;

	@GetMapping("/suppliers")
	public String getSuppliers(Model model) {
		model.addAttribute("suppliers", supplierService.getSuppliers());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		return "Supplier";
	}

	@PostMapping("/supplier/addNew")
	public String addNewSupplier(Supplier supplier) {
		supplierService.saveSupplier(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping("/supplier/findById")
	@ResponseBody
	public Optional<Supplier> getSupplierById(int id) {
		return supplierService.getSupplierById(id);
	}

	@RequestMapping(value = "/supplier/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateSupplier(Supplier supplier) {
		supplierService.saveSupplier(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping(value = "/supplier/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteSupplier(int id) {
		supplierService.deleteSupplier(id);
		return "redirect:/suppliers";
	}
}
