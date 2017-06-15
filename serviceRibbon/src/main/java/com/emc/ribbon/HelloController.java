package com.emc.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloController {

		@Autowired
		RestTemplate restTemplate;
		
		@RequestMapping(value="/sayHello" , method = RequestMethod.GET)
		public String sayHello(@RequestParam String name){
			System.out.println("-------------------------hello console----------------------");
			return restTemplate.getForEntity("http://HELLO-SERVICE/sayHello?name=plocen", String.class).getBody();
			
			}
		}