package com.springboot.user;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.spring.springboot.bean.User;
import com.spring.springboot.mapper.user.UserMapper;
import com.study.eureka.client.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Ignore
public class UserTest {
	
	@Autowired
	private UserMapper userMapper;

	@Test
	public void findByUserName() throws Exception {
		User user = userMapper.findUserByName("sam");
		Assert.notNull(user);
	}
	
}
