package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.JobTitle;
import com.fleet.thieuduong.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {
	@Autowired
	JobTitleRepository jobTitleRepository;

	// Get all countries
	public List<JobTitle> getJobTitles() {
		return jobTitleRepository.findAll();
	}

	// New JobTitle
	public void saveJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}

	// Get JobTitle by Id
	public Optional<JobTitle> getJobTitleById(int id) {
		return jobTitleRepository.findById(id);
	}

	// Delete JobTitle
	public void deleteJobTitle(int id) {
		jobTitleRepository.deleteById(id);
	}
}
