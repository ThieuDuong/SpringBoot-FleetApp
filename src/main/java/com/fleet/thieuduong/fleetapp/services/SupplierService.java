package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.Supplier;
import com.fleet.thieuduong.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	SupplierRepository supplierRepoFsitory;

	// Get all countries
	public List<Supplier> getSuppliers() {
		return supplierRepoFsitory.findAll();
	}

	// New Supplier
	public void saveSupplier(Supplier supplier) {
		supplierRepoFsitory.save(supplier);
	}

	// Get Supplier by Id
	public Optional<Supplier> getSupplierById(int id) {
		return supplierRepoFsitory.findById(id);
	}

	// Delete Supplier
	public void deleteSupplier(int id) {
		supplierRepoFsitory.deleteById(id);
	}
}
