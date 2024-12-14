package com.example.vra.mapper;

import org.springframework.stereotype.Component;

import com.example.vra.entity.User;
import com.example.vra.requestdto.UserRequest;
import com.example.vra.responsedto.UserResponse;

@Component
public class UserMapper {

	public User mapToUser(UserRequest request) {
		User user=new User();
		user.setUserName(request.getUserName());
		user.setUserPassword(request.getUserPassword());
		user.setUserEmail(request.getUserEmail());
		user.setUserPhoneNumber(request.getUserPhoneNumber());
		return user;
	}
	
	public UserResponse mapToResponse(User user) {
		UserResponse userResponse=new UserResponse();
		userResponse.setUserName(user.getUserName());
		userResponse.setUserId(user.getUserId());
		userResponse.setUserEmail(user.getUserEmail());
		userResponse.setUserPhoneNumber(user.getUserPhoneNumber());
		userResponse.setUserRole(user.getUserRole());

		return userResponse;
	}
}
