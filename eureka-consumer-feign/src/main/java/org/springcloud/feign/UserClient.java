package org.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface UserClient {

  @GetMapping("/login")
  String login(
      @RequestParam("userName") String userName, @RequestParam("password") String password);
}
