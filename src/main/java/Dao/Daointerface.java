package Dao;

import model.User;

public interface Daointerface {
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User getUser(String username);
    boolean comparePassword(String username, String password);
}
