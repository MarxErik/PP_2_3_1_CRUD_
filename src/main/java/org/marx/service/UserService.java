package org.marx.service;

import org.marx.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User readUser(Integer userId);

    List<User> readAllUsers();

    User updateUser(User user);


    User deleteUser(Integer userId);


}

