package com.spring.springboot.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.spring.springboot.bean.User;
import com.spring.springboot.mapper.user.UserMapper;


/**
 * @author Mason
 * @date 2017-08-15
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger _logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@SuppressWarnings("rawtypes")
	@Autowired
//	private RedisTemplate redisTemplate;
	
	
	/**
	 * Get all user info
	 */
//	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUser() {
		List<User> list = new ArrayList<>();
		try {
//			ValueOperations<String, List<User>> operations = redisTemplate.opsForValue();
//			if(redisTemplate.hasKey("users")) {
//				list = operations.get("users");
//				_logger.info("Get users info from redis >> " + list);
//			} else {
				list = userMapper.getUser();
//				operations.set("users", list, 10, TimeUnit.SECONDS);
//				_logger.info("Get users info from database and cache it to redis >> " + list);
//			}
		} catch (Exception e) {
			_logger.error("Get users info failed => " + e);
		}
		return list;
	}

	
	/**
	 * Get user info by userName
	 */
//	@SuppressWarnings("unchecked")
	@Override
	public User findUserByName(String userName) {
		User user = null;
		String key = "user_" + userName;
		try {
//			ValueOperations<String, User> operations = redisTemplate.opsForValue();
//			if(redisTemplate.hasKey(key)) {
//				user = operations.get(key);
//				_logger.info("Get user info from redis >> " + user);
//			} else {
				user = userMapper.findUserByName(userName);
//				operations.set(key, user, 10, TimeUnit.SECONDS);
//				_logger.info("Get user info from database and cache it to redis >> " + user);
//			}
		} catch (Exception e) {
			_logger.error("Get user info failed => " + e);
		}
		return user;
	}

	@Override
	public int createUser(String userName, String description) {
		// TODO Auto-generated method stub
		return 0;
	}

}
