package com.emc.ribbon;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emc.ribbon.HelloService;

@RestController
public class LoginController {
	
	@Resource
	private LoginService login;
	
	@Resource
	private HelloService hello;
	
	@RequestMapping(value="/login/{userName}/{password}" , method = RequestMethod.GET)
	public String login(@PathVariable("userName") String userName, @PathVariable("password") String password){
		return login.login(userName, password);
	}
	
	@RequestMapping(value="/login/sayHello" , method = RequestMethod.GET)
	public String sayHello(@RequestParam String userName, @RequestParam String password){
		return hello.sayHello(userName, password);
		}
}
