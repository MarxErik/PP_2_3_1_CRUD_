package org.marx.service;

import org.marx.dao.UserDao;
import org.marx.model.User;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    static {
        String path = Objects.requireNonNull(UserServiceImpl.class.getClassLoader()
                .getResource("logging.properties")).getFile();
        System.setProperty("java.util.logging.config.file", path);
    }


    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public Optional<User> getUser(long userId) {
        return userDao.getUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void deleteUser(long userId) {
        try {
            userDao.deleteUser(userId);
        } catch (InvalidDataAccessApiUsageException e) {
            logger.info("Not found User");
        }
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}