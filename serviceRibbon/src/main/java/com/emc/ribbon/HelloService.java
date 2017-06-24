package com.emc.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * @HystrixCommand 断路器
	 * fallbackMethod 回调函数， 如果RestTemplate调用失败，
	 * 	就调用sayHelloFallBack直接返回客户端， 防止请求阻塞过多，导致服务崩溃
	 * @return String
	 */
	@HystrixCommand(fallbackMethod = "sayHelloFallBack")
	public String sayHello() {
		
		return restTemplate.getForEntity("http://HELLO-SERVICE/sayHello?name=plocen", String.class).getBody();
	}
	
	public String sayHelloFallBack(){
		return "error page! please check your service"; 
			
	}
	
}
