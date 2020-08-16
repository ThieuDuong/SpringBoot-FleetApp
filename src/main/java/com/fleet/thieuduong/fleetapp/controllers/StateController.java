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

import com.fleet.thieuduong.fleetapp.models.State;
import com.fleet.thieuduong.fleetapp.services.CountryService;
import com.fleet.thieuduong.fleetapp.services.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;

	@GetMapping("/states")
	public String getStates(Model model) {
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		return "State";
	}

	@PostMapping("/states/addNew")
	public String addNewstate(State state) {
		stateService.saveState(state);
		return "redirect:/states";
	}

	@RequestMapping("/states/findById")
	@ResponseBody
	public Optional<State> getStateById(int id) {
		return stateService.getStateById(id);
	}

	@RequestMapping(value = "/states/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateState(State state) {
		stateService.saveState(state);
		return "redirect:/states";
	}

	@RequestMapping(value = "/states/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteState(int id) {
		stateService.deleteState(id);
		return "redirect:/states";
	}
}
