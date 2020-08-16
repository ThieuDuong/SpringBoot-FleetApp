package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.Client;
import com.fleet.thieuduong.fleetapp.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;

	// Get all countries
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	// New Client
	public void saveClient(Client client) {
		clientRepository.save(client);
	}

	// Get Client by Id
	public Optional<Client> getClientById(int id) {
		return clientRepository.findById(id);
	}

	// Delete Client
	public void deleteClient(int id) {
		clientRepository.deleteById(id);
	}
}
