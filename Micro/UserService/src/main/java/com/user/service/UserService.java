package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {

	User saveUser(User u);
	
	List<User> getAllUsers();
	
	User getUser(String userId);

	
}
