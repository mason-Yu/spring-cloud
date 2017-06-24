package com.emc.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

		@Autowired
		private HelloService hello;
		
		@RequestMapping(value="/sayHello/{name}" , method = RequestMethod.GET)
		public String sayHello(@PathVariable String name ){
			System.out.println("send name:" + name + "----------------------------------------");
			return hello.sayHello();
			}
		}