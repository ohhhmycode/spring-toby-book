package dev.ohhhmycode.user.service;

import dev.ohhhmycode.user.domain.User;

public interface UserLevelUpgradePolicy {
    boolean canUpgradeLevel(User user);
    void upgradeLevel(User user);
}
