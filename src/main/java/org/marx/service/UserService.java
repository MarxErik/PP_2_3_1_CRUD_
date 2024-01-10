package org.marx.service;

import org.marx.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    Optional<User> readUser(long userId);

    List<User> readAllUsers();

    void updateUser(User user);

    Optional<User> deleteUser(long userId);
}