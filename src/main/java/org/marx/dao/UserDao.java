package org.marx.dao;

import org.marx.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    //CRRUD
    void createUser(User user);

    Optional<User> readUser(long userId);

    List<User> readAllUsers();

    Optional<User> deleteUser(long userId);

    User updateUser(User user);

}
