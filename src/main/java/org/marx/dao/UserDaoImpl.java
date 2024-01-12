package org.marx.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.marx.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager env;

    @Override
    @Transactional
    public void createUser(User user) {
        env.persist(user);
    }

    @Override
    public Optional<User> getUser(long userId) {
        return Optional.ofNullable(env.find(User.class, userId));
    }

    @Override
    public List<User> getAllUsers() {
        return env.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        env.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(long userId) {
        Optional<User> user = getUser(userId);
        env.remove(user.get());
    }
}
