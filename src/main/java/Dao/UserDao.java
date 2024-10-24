package Dao;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import model.User;

public class UserDao implements Daointerface{
    protected final Cache<String, User> cache = Caffeine.newBuilder()
            .maximumSize(1000)
            .build();

    @Override
    public void addUser(User user) {
        cache.put(user.getUsername(), user);
    }

    @Override
    public void deleteUser(User user) {
        cache.invalidate(user.getUsername());
    }

    @Override
    public void updateUser(User user) {
        cache.put(user.getUsername(), user);
    }

    @Override
    public User getUser(String username) {
        return cache.getIfPresent(username);
    }

    @Override
    public boolean comparePassword(String username, String password) {
        User user = cache.getIfPresent(username);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}
