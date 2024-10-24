package Service;

import Dao.UserDao;
import model.User;

public class UserService {
    UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User getUser(String username) {
        return userDao.getUser(username);
    }

    public boolean comparePassword(String username, String psw) {
        return userDao.comparePassword(username, psw);
    }
}
