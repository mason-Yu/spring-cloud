package com.study.eureka.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/sayHello")
	public String sayhello(@RequestParam String name) {
		return "Hello" + name + "!";
		
	}
}
