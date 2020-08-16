package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.Vehicle;
import com.fleet.thieuduong.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;

	// Get all vehicles
	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
	}

	// New Vehicle
	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	// Get Vehicle by Id
	public Optional<Vehicle> getVehicleById(int id) {
		return vehicleRepository.findById(id);
	}

	// Delete Vehicle
	public void deleteVehicle(int id) {
		vehicleRepository.deleteById(id);
	}
}
