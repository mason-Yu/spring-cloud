package com.emc.ribbon;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Resource private LoginService login;

  @RequestMapping(value = "/login/{userName}/{password}", method = RequestMethod.GET)
  public String login(
      @PathVariable("userName") String userName, @PathVariable("password") String password) {
    return login.login(userName, password);
  }
}
