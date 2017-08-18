package com.study.eureka.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.service.user.UserService;


@RestController
public class HelloController {
	
	private final Logger logger = Logger.getLogger(getClass());
	private static String RES_SUCCESS = "Success";
	private static String RES_FAILED = "Invalid user name or password";
	
	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/sayHello", method = RequestMethod.GET)
	public Map<String, String> sayhello(@RequestParam String userName,
							@RequestParam String password) {
		Map<String, String> res = new HashMap<>();
		ServiceInstance instance = client.getLocalServiceInstance();
		if("admin".equals(userName) && "Admin123!".equals(password)) {
			logger.info("/sayhello, host: " + instance.getHost() + ", service_id: " 
					+ instance.getServiceId() + ", result: Hello "+ userName+ "!");
			
			res.put("success", RES_SUCCESS);
		} else {
			res.put("errorMsg", RES_FAILED);
		}
		return res;
	}
}
