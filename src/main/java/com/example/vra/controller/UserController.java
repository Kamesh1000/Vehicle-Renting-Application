package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.vra.entity.User;
import com.example.vra.service.UserService;
import com.example.vra.util.ResponseStructure;

@RestController
public class UserController {

private final UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService=userService;
	}
	
	@PostMapping("/add-user")
	public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user) {
		user = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", user));
	}
	@GetMapping("/add-image")
	public ResponseEntity<ResponseStructure<User>> updatePhoto(@RequestParam int userId,@RequestParam MultipartFile image,@RequestParam String contentType){
		User user = userService.updatePhoto(userId,image,contentType);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", user));
	}
}
