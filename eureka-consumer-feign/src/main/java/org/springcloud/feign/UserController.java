package org.springcloud.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired UserClient userClient;

  @GetMapping("/login/{userName}/{password}")
  public String login(
      @PathVariable("userName") String userName, @PathVariable("password") String password) {
    return userClient.login(userName, password);
  }
}
