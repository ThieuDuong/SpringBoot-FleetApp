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

import com.fleet.thieuduong.fleetapp.models.Client;
import com.fleet.thieuduong.fleetapp.services.ClientService;
import com.fleet.thieuduong.fleetapp.services.CountryService;
import com.fleet.thieuduong.fleetapp.services.StateService;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;

	@GetMapping("/clients")
	public String getclients(Model model) {
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		return "Client";
	}

	@PostMapping("/client/addNew")
	public String addNewClient(Client Client) {
		clientService.saveClient(Client);
		return "redirect:/clients";
	}
	
	@RequestMapping("/client/findById")
	@ResponseBody
	public Optional<Client> getClientById(int id) {
		return clientService.getClientById(id);
	}
	
	@RequestMapping(value="/client/edit", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updateClient(Client Client){
		clientService.saveClient(Client);
		return "redirect:/clients";
	}
	
	@RequestMapping(value="/client/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteClient(int id){
		clientService.deleteClient(id);
		return "redirect:/clients";
	}
}
