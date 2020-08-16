package com.fleet.thieuduong.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fleet.thieuduong.fleetapp.models.User;
import com.fleet.thieuduong.fleetapp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Get all users
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	// New User
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	// Get User by Id
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}

	// Delete User
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
