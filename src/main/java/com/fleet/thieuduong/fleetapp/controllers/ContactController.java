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

import com.fleet.thieuduong.fleetapp.models.Contact;
import com.fleet.thieuduong.fleetapp.services.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;

	@GetMapping("/contacts")
	public String getcontacts(Model model) {
		model.addAttribute("contacts", contactService.getContacts());
		return "Contacts";
	}

	@PostMapping("/contact/addNew")
	public String addNewContact(Contact Contact) {
		contactService.saveContact(Contact);
		return "redirect:/contacts";
	}

	@RequestMapping("/contact/findById")
	@ResponseBody
	public Optional<Contact> getContactById(int id) {
		return contactService.getContactById(id);
	}

	@RequestMapping(value = "/contact/edit", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateContact(Contact Contact) {
		contactService.saveContact(Contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/contact/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteContact(int id) {
		contactService.deleteContact(id);
		return "redirect:/contacts";
	}
}
