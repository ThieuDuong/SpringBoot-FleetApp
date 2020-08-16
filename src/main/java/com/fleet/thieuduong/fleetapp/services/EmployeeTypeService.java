package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.EmployeeType;
import com.fleet.thieuduong.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	@Autowired
	EmployeeTypeRepository employeeTypeRepository;

	// Get all countries
	public List<EmployeeType> getEmployeeTypes() {
		return employeeTypeRepository.findAll();
	}

	// New EmployeeType
	public void saveEmployeeType(EmployeeType EmployeeType) {
		employeeTypeRepository.save(EmployeeType);
	}

	// Get EmployeeType by Id
	public Optional<EmployeeType> getEmployeeTypeById(int id) {
		return employeeTypeRepository.findById(id);
	}

	// Delete EmployeeType
	public void deleteEmployeeType(int id) {
		employeeTypeRepository.deleteById(id);
	}
}
