package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.vra.requestdto.UserRequest;
import com.example.vra.responsedto.UserResponse;
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
	public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).
				body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created",userService.addUser(request)));
	}
	@GetMapping("/get-user")
	public ResponseEntity<ResponseStructure<UserResponse>> getUser(@RequestParam int userId){
		return ResponseEntity.status(HttpStatus.CREATED).
				body(ResponseStructure.create(HttpStatus.OK.value(),"User Details",userService.getUser(userId)));
	}
}
