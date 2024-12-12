package com.example.vra.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.vra.entity.Image;
import com.example.vra.repository.ImageRepository;
import com.example.vra.repository.UserRepository;

@Service
public class ImageService {

	private final ImageRepository imageRepository;
	private final UserRepository userRepository;
	
	ImageService(ImageRepository imageRepository, UserRepository userRepository){
		super();
		this.imageRepository=imageRepository;
		this.userRepository = userRepository;
	}

	public void uploadUserProfilePicture(int userId, MultipartFile file) {
		
		userRepository.findById(userId)
		.map(user -> {
			
			Image image = this.createImage(file);
			image = imageRepository.save(image);
			
			user.setImage(image);
			return userRepository.save(user);
			
		}).orElseThrow(() -> new RuntimeException(""));
	}
	
	private Image createImage(MultipartFile file) {
		try {
			Image image = new Image();
			image.setContentType(file.getContentType());
			image.setImageBytes(file.getBytes());
			return image;
		} catch (IOException e) {
				throw new RuntimeException();
		}
	}

	public Image getImage(int imageId) {
		return imageRepository.findById(imageId).orElseThrow();
	}

}
