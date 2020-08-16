package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.VehicleType;
import com.fleet.thieuduong.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	@Autowired
	VehicleTypeRepository vehicleTypeRepository;

	// Get all countries
	public List<VehicleType> getVehicleType() {
		return vehicleTypeRepository.findAll();
	}

	// New vehicleType
	public void saveVehicleType(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}

	// Get vehicleType by Id
	public Optional<VehicleType> getVehicleTypeById(int id) {
		return vehicleTypeRepository.findById(id);
	}

	// Delete vehicleType
	public void deleteVehicleType(int id) {
		vehicleTypeRepository.deleteById(id);
	}
}
