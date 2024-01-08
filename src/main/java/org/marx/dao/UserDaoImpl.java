package org.marx.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.marx.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager env;

    @Override
    @Transactional
    public User createUser(User user) {
        return env.merge(user);
    }

    @Override
    public User readUser(Integer userId) {
        return env.find(User.class, userId);
    }

    @Override
    public List<User> readAllUsers() {
        return env.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return env.merge(user);
    }


    @Override
    @Transactional
    public User deleteUser(Integer userId) {
        User user = readUser(userId);
        env.remove(user);
        return user;
    }
}
