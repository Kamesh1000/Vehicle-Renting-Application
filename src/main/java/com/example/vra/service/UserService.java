package com.example.vra.service;

import org.springframework.stereotype.Service;

import com.example.vra.entity.Image;
import com.example.vra.entity.User;
import com.example.vra.exception.UserNotFoundException;
import com.example.vra.mapper.UserMapper;
import com.example.vra.repository.UserRepository;
import com.example.vra.requestdto.UserRequest;
import com.example.vra.responsedto.UserResponse;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public UserResponse addUser(UserRequest request) {
		return userMapper.mapToResponse(userRepository.save(userMapper.mapToUser(request)));
	}

	public UserResponse getUser(int userId) {
		return userRepository.findById(userId).map((user)->{
				UserResponse response=userMapper.mapToResponse(user);
				setProfilePictureurl(response,user.getImage());
				return response;
		}).
		 orElseThrow(()->new UserNotFoundException("User Not Exist"));
	}

	private void setProfilePictureurl(UserResponse response, Image profilePicture) {
		if(profilePicture != null)
			response.setUserProfileLink("/get-user-profile-picture?imageId="+ profilePicture.getImageId());
	}


}
