package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.Country;
import com.fleet.thieuduong.fleetapp.repositories.CountryRepository;

@Service
public class CountryService {
	@Autowired
	CountryRepository countryRepository;

	// Get all countries
	public List<Country> getCountries() {
		return countryRepository.findAll();
	}

	// New Country
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}

	// Get country by Id
	public Optional<Country> getCountryById(int id) {
		return countryRepository.findById(id);
	}
	
	// Delete country
	public void deleteCountry(int id) {
		countryRepository.deleteById(id);
	}
	
	public List<String> getColumnName(){
		return countryRepository.getColumnName();
	}
}
