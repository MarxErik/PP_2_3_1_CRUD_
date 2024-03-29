package org.marx.dao;

import org.marx.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    //CRRUD
    void createUser(User user);

    Optional<User> getUser(long userId);

    List<User> getAllUsers();

    void deleteUser(long userId);

    void updateUser(User user);

}
