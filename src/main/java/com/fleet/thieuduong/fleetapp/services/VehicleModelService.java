package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.VehicleModel;
import com.fleet.thieuduong.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	@Autowired
	VehicleModelRepository vehicleModelRepository;

	// Get all countries
	public List<VehicleModel> getVehicleModel() {
		return vehicleModelRepository.findAll();
	}

	// New vehicleModel
	public void saveVehicleModel(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}

	// Get vehicleModel by Id
	public Optional<VehicleModel> getVehicleModelById(int id) {
		return vehicleModelRepository.findById(id);
	}

	// Delete vehicleModel
	public void deleteVehicleModel(int id) {
		vehicleModelRepository.deleteById(id);
	}
}
