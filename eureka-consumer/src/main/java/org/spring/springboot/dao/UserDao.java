package org.spring.springboot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.User;

public interface UserDao {

  List<User> getUser();

  User findUserByName(String userName);

  Long saveUser(User user);

  Long updateUser(User user);

  Long deleteUser(@Param("id") String id);

  int checkExists(@Param("userName") String userName, @Param("password") String password);
}
