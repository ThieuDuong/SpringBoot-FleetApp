package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.VehicleMovement;
import com.fleet.thieuduong.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	@Autowired
	VehicleMovementRepository vehicleMovementRepository;

	// Get all countries
	public List<VehicleMovement> getVehicleMovement() {
		return vehicleMovementRepository.findAll();
	}

	// New vehicleMovement
	public void saveVehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}

	// Get vehicleMovement by Id
	public Optional<VehicleMovement> getVehicleMovementById(int id) {
		return vehicleMovementRepository.findById(id);
	}

	// Delete vehicleMovement
	public void deleteVehicleMovement(int id) {
		vehicleMovementRepository.deleteById(id);
	}

}
