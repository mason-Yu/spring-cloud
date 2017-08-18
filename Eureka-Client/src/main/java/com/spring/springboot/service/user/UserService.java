package com.spring.springboot.service.user;

import java.util.List;

import com.spring.springboot.bean.User;

public interface UserService {

	List<User> getUser();
	
	User findUserByName(String userName);
	
	int createUser(String userName, String description);
	
}
