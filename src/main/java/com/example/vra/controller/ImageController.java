package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
import com.example.vra.service.ImageService;
import com.example.vra.util.SimpleResponseStructure;

@RestController
public class ImageController {
	
	private final ImageService imageService;
	
	ImageController(ImageService imageService){
		super();
		this.imageService=imageService;
	}

	@PostMapping("/upload-user-profile-picture")
	public ResponseEntity<SimpleResponseStructure> setImage(@RequestParam int userId,@RequestParam MultipartFile file) {
		imageService.uploadUserProfilePicture(userId, file);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(SimpleResponseStructure.create(HttpStatus.OK.value(), "user profile picture uploaded"));
	}
	
	@GetMapping("/get-user-profile-picture")
	public ResponseEntity<byte[]> getImage(@RequestParam int imageId){
		Image image=imageService.getImage(imageId);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf(image.getContentType()))
				.body(image.getImageBytes());
	}
}
