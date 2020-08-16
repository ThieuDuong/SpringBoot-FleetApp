package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.Location;
import com.fleet.thieuduong.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {
	@Autowired
	LocationRepository locationRepository;

	// Get all Locations
	public List<Location> getLocations() {
		return locationRepository.findAll();
	}

	// New Location
	public void saveLocation(Location location) {
		locationRepository.save(location);
	}

	// Get Location by Id
	public Optional<Location> getLocationById(int id) {
		return locationRepository.findById(id);
	}

	// Delete Location
	public void deleteLocation(int id) {
		locationRepository.deleteById(id);
	}
}
