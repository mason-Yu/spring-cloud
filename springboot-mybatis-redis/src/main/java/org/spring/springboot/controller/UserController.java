package org.spring.springboot.controller;

import org.apache.log4j.Logger;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.my.springcloud.utils.RespBody;

@RestController
public class UserController {

  private final Logger logger = Logger.getLogger(UserController.class);
  private static String RES_SUCCESS = "Success";
  private static String RES_FAILED = "Invalid user name or password";

  @Autowired private DiscoveryClient client;

  @Autowired private UserService userService;

  @RequestMapping(value = "login", method = RequestMethod.GET)
  public RespBody login(@RequestParam String userName, @RequestParam String password)
      throws InterruptedException {
    Thread.sleep(5);
    ServiceInstance instance = client.getLocalServiceInstance();
    logger.info(
        String.format(
            "/login, host: %s , service_id: %s, Login user: %s",
            instance.getHost(), instance.getServiceId(), userName));
    int count;
    try {
      count = userService.checkExists(userName, password);
      if (count > 0) {
        return RespBody.succeed(RES_SUCCESS);
      }
      logger.warn(String.format("user %s login with incorrent password %s", userName, password));
      return RespBody.failed(RES_FAILED);
    } catch (Exception e) {
      logger.error(String.format("user %s login failed: %s", userName, e));
      return RespBody.failed(RES_FAILED);
    }
  }
}
