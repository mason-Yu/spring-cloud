package com.spring.springboot.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.springboot.bean.User;

public interface UserMapper {

	List<User> getUser();
	
	User findUserByName(String userName);
	
	Long saveUser(User user);
	
	Long updateUser(User user);
	
	Long deleteUser(@Param("id") String id);
	
}
