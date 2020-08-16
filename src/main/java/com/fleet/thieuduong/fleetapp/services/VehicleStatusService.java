package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.VehicleStatus;
import com.fleet.thieuduong.fleetapp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {
	@Autowired
	VehicleStatusRepository vehicleStatusRepository;

	// Get all countries
	public List<VehicleStatus> getVehicleStatus() {
		return vehicleStatusRepository.findAll();
	}

	// New vehicleStatus
	public void saveVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}

	// Get vehicleStatus by Id
	public Optional<VehicleStatus> getVehicleStatusById(int id) {
		return vehicleStatusRepository.findById(id);
	}

	// Delete vehicleStatus
	public void deleteVehicleStatus(int id) {
		vehicleStatusRepository.deleteById(id);
	}
}
