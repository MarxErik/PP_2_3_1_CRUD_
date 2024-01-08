package org.marx.dao;

import org.marx.model.User;

import java.util.List;

public interface UserDao {
    //CRRUD
    User createUser(User user);

    User readUser(Integer userId);

    List<User> readAllUsers();

    User deleteUser(Integer userId);

    User updateUser(User user);

}
