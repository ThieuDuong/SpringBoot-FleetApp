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

import com.fleet.thieuduong.fleetapp.models.Location;
import com.fleet.thieuduong.fleetapp.services.CountryService;
import com.fleet.thieuduong.fleetapp.services.LocationService;
import com.fleet.thieuduong.fleetapp.services.StateService;

@Controller
public class LocationController {
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/locations")
	public String getLocations(Model model) {
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
//		System.out.println(stateService.getStateNameByCountryId(8));
		return "Location";
	}
	
	@PostMapping("/locations/addNew")
	public String addNewLocation(Location location) {
		locationService.saveLocation(location);
		return "redirect:/locations";
	}
	
	@RequestMapping("/locations/findById")
	@ResponseBody
	public Optional<Location> getLocationById(int id) {
		return locationService.getLocationById(id);
	}
	
	@RequestMapping(value="/locations/edit", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateLocation(Location location){
		locationService.saveLocation(location);
		return "redirect:/locations";
	}
	
	@RequestMapping(value="/locations/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteLocation(int id){
		locationService.deleteLocation(id);
		return "redirect:/locations";
	}
}
