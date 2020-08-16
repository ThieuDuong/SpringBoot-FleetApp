package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.VehicleHire;
import com.fleet.thieuduong.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
	@Autowired
	VehicleHireRepository vehicleHireRepository;

	// Get all VehicleHire
	public List<VehicleHire> getVehicleHires() {
		return vehicleHireRepository.findAll();
	}

	// New VehicleHire
	public void saveVehicleHire(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}

	// Get VehicleHire by Id
	public Optional<VehicleHire> getVehicleHireById(int id) {
		return vehicleHireRepository.findById(id);
	}

	// Delete VehicleHire
	public void deleteVehicleHire(int id) {
		vehicleHireRepository.deleteById(id);
	}
}
