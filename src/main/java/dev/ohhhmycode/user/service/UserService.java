package dev.ohhhmycode.user.service;

import dev.ohhhmycode.user.domain.User;

public interface UserService {
    void add(User user);
    void upgradeLevels();
}
