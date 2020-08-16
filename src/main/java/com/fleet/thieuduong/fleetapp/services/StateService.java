package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.State;
import com.fleet.thieuduong.fleetapp.repositories.StateRepository;

@Service
public class StateService {
	@Autowired
	StateRepository stateRepository;

	// Get all states
	public List<State> getStates() {
		return stateRepository.findAll();
	}

	// New State
	public void saveState(State state) {
		stateRepository.save(state);
	}

	// Get state by Id
	public Optional<State> getStateById(int id) {
		return stateRepository.findById(id);
	}

	// Get state by Id
	public List<String> getStateNameByCountryId(Integer countryid){
		return stateRepository.findStateNameByCountryId(countryid);
	}

	// Delete state
	public void deleteState(int id) {
		stateRepository.deleteById(id);
	}
}
