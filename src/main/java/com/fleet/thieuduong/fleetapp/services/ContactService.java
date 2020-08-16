package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.Contact;
import com.fleet.thieuduong.fleetapp.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	ContactRepository contactRepository;

	// Get all contacts
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}

	// New Contact
	public void saveContact(Contact contact) {
		contactRepository.save(contact);
	}

	// Get Contact by Id
	public Optional<Contact> getContactById(int id) {
		return contactRepository.findById(id);
	}

	// Delete Contact
	public void deleteContact(int id) {
		contactRepository.deleteById(id);
	}
}
