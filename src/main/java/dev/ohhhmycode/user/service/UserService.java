package dev.ohhhmycode.user.service;


import dev.ohhhmycode.user.dao.UserDao;

public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
