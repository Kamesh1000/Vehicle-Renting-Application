package com.example.vra.responsedto;

import com.example.vra.enums.Role;

public class UserResponse {
	private int userId;
	private String userName;
	private String userEmail;
	private String userPhoneNumber;
	private Role userRole;
	private String userProfileLink;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	public String getUserProfileLink() {
		return userProfileLink;
	}
	public void setUserProfileLink(String userProfileLink) {
		this.userProfileLink = userProfileLink;
	}
}
