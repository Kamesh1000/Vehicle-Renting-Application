package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vra.enums.Role;
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
	
	@GetMapping("/get-user")
	public ResponseEntity<ResponseStructure<UserResponse>> getUser(@RequestParam int userId){
		return ResponseEntity.status(HttpStatus.CREATED).
				body(ResponseStructure.create(HttpStatus.OK.value(),"User Details",userService.getUser(userId)));
	}
	@PostMapping("/update-user")
	public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest request,@RequestParam int userId){
		return ResponseEntity.status(HttpStatus.CREATED).
				body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created",userService.updateUser(request,userId)));
	}
	@PostMapping("/register-customer")
	public ResponseEntity<ResponseStructure<UserResponse>> registerCustomer(@RequestBody UserRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).
				body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created",userService.registerCustomer(request,Role.Customer)));
	}
	@PostMapping("/register-rentingPartner")
	public ResponseEntity<ResponseStructure<UserResponse>> registerRentingPartner(@RequestBody UserRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).
				body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created",userService.registerRentingPartner(request,Role.Renting_Partner)));
	}
}
