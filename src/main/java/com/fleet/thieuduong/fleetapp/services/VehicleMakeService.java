package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.VehicleMake;
import com.fleet.thieuduong.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	@Autowired
	VehicleMakeRepository vehicleMakeRepository;

	// Get all countries
	public List<VehicleMake> getVehicleMake() {
		return vehicleMakeRepository.findAll();
	}

	// New vehicleMake
	public void saveVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}

	// Get vehicleMake by Id
	public Optional<VehicleMake> getVehicleMakeById(int id) {
		return vehicleMakeRepository.findById(id);
	}
	
	// Delete vehicleMake
	public void deleteVehicleMake(int id) {
		vehicleMakeRepository.deleteById(id);
	}
}
