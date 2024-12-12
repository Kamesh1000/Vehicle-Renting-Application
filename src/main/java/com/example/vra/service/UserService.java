package com.example.vra.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
import com.example.vra.entity.User;
import com.example.vra.repository.ImageRepository;
import com.example.vra.repository.UserRepository;

@Service
public class UserService {

private final UserRepository userRepository;
private final ImageRepository imageRepository;
	
	public UserService(UserRepository userRepository,ImageRepository imageRepository) {
		super();
		this.userRepository=userRepository;
		this.imageRepository=imageRepository;
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public void updatePhoto(int userId, MultipartFile image1,String contentType) {
	        userRepository.findById(userId).map((user)->{
			Image image=new Image();
			try {
				image.setImageBytes(image1.getBytes());
				image.setContentType(contentType);
				user.setImage(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			imageRepository.save(image);
			return userRepository.save(user);
		}).orElseThrow();
	}
}
