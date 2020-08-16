package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.VehicleMaintenance;
import com.fleet.thieuduong.fleetapp.repositories.VehicleMaintenanceRepository;


@Service
public class VehicleMaintenanceService {
	@Autowired
	VehicleMaintenanceRepository vehicleMaintenanceRepository;

	// Get all countries
	public List<VehicleMaintenance> getVehicleMaintenances() {
		return vehicleMaintenanceRepository.findAll();
	}

	// New VehicleMaintenance
	public void saveVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}

	// Get VehicleMaintenance by Id
	public Optional<VehicleMaintenance> getVehicleMaintenanceById(int id) {
		return vehicleMaintenanceRepository.findById(id);
	}

	// Delete VehicleMaintenance
	public void deleteVehicleMaintenance(int id) {
		vehicleMaintenanceRepository.deleteById(id);
	}
}
