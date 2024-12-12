package com.example.vra.service;

import org.springframework.stereotype.Service;
import com.example.vra.entity.Image;
import com.example.vra.entity.User;
import com.example.vra.repository.UserRepository;

@Service
public class UserService {

private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository=userRepository;
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User updatePhoto(int userId, Image image) {
		return userRepository.findById(userId).map((user)->{
			user.setImage(image);
			return userRepository.save(user);
		}).orElseThrow();
	}
}
