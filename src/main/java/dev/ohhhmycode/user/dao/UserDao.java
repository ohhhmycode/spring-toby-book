package dev.ohhhmycode.user.dao;

import dev.ohhhmycode.user.domain.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User get(String id);
    List<User> getAll();
    void update(User user);
    void deleteAll();
    int getCount();
}
