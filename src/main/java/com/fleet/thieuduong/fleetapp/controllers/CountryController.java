package com.fleet.thieuduong.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.thieuduong.fleetapp.models.Country;
import com.fleet.thieuduong.fleetapp.services.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public String getCountries(Model model) {
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		return "Country";
	}

	@PostMapping("/countries/addNew")
	public String addNewCountry(Country country) {
		countryService.saveCountry(country);
		return "redirect:/countries";
	}
	
	@RequestMapping("/countries/findById")
	@ResponseBody
	public Optional<Country> getCountryById(int id) {
		return countryService.getCountryById(id);
	}
	
	@RequestMapping(value="/countries/edit", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateCountry(Country country){
		countryService.saveCountry(country);
		return "redirect:/countries";
	}
	
	@RequestMapping(value="/countries/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteCountry(int id){
		countryService.deleteCountry(id);
		return "redirect:/countries";
	}
}
