package org.marx.service;

import org.marx.dao.UserDao;
import org.marx.model.User;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public Optional<User> readUser(long userId) {
        return userDao.readUser(userId);
    }

    @Override
    public List<User> readAllUsers() {
        return userDao.readAllUsers();
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public Optional<User> deleteUser(long userId) {
        try {
            return userDao.deleteUser(userId);
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println("Not found User");
        }
        return Optional.empty();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}