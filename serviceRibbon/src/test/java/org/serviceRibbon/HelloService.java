package org.serviceRibbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class HelloService {
	@Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA.CLIENT.01/sayHello?name="+name,String.class);
    }

}
