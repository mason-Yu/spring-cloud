package org.spring.springboot.service;

import java.util.List;
import org.spring.springboot.domain.User;

public interface UserService {

  List<User> getUser();

  User findUserByName(String userName);

  int createUser(String userName, String description);

  int checkExists(String userName, String password);
}
