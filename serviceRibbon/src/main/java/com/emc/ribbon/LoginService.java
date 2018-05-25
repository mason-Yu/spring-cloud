package com.emc.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class LoginService {
  @Autowired RestTemplate restTemplate;

  /**
   * @HystrixCommand 断路器 fallbackMethod 回调函数， 如果RestTemplate调用失败， 就调用sayHelloFallBack直接返回客户端，
   * 防止请求阻塞过多，导致服务崩溃
   *
   * @return String
   */
  @HystrixCommand(fallbackMethod = "loginFallBack")
  public String login(String userName, String password) {

    return restTemplate
        .getForEntity(
            "http://USER-SERVICE/login?userName=" + userName + "&password=" + password,
            String.class)
        .getBody();
  }

  public String loginFallBack() {
    return "error page! please check your service";
  }
}
