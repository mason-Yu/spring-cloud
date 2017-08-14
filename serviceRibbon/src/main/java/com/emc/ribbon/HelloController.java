package com.emc.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

		@Autowired
		private HelloService hello;
		
		@RequestMapping(value="/sayHello" , method = RequestMethod.GET)
		public String sayHello(@RequestParam String userName, @RequestParam String password){
			System.out.println("---------------------------------" + userName + "-----------------------------------");
			return hello.sayHello(userName, password);
			}
		}