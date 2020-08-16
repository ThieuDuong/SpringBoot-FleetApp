package com.fleet.thieuduong.fleetapp.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fleet.thieuduong.fleetapp.models.Employee;
import com.fleet.thieuduong.fleetapp.repositories.EmployeeRepository;
import com.fleet.thieuduong.fleetapp.repositories.FilesStorageService;

@Service
public class EmployeeService implements FilesStorageService {
	@Autowired
	EmployeeRepository employeeRepository;

	// Get all employees
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	// New Employee
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	// Get Employee by Id
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	// Delete Employee
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	/********** Upload file ***************/
	private final Path root = Paths.get("src/main/resources/static/img/photo");

	@Override
	public void init() {
		try {
			Files.createDirectory(root);
			System.out.println("root: " + root);
			System.out.println("root: " + root);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	@Override
	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			System.out.println("original name: " + file.getOriginalFilename());
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	@Override
	public Resource load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
