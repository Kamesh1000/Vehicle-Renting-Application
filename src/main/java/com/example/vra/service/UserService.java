package com.example.vra.service;

import org.springframework.stereotype.Service;

import com.example.vra.controller.ImageController;
import com.example.vra.entity.User;
import com.example.vra.repository.UserRepository;

@Service
public class UserService {

private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository,ImageController imageController) {
		super();
		this.userRepository=userRepository;
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

}
