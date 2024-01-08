package org.marx.service;

import org.marx.dao.UserDao;
import org.marx.dao.UserDaoImpl;
import org.marx.model.User;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User readUser(Integer userId) {
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
    public User deleteUser(Integer userId) {
        try {
            return userDao.deleteUser(userId);
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println("Not found User");
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }


}
