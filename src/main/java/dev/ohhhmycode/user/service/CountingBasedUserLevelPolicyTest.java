package dev.ohhhmycode.user.service;

import dev.ohhhmycode.user.domain.Level;
import dev.ohhhmycode.user.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CountingBasedUserLevelPolicyTest {

    private UserLevelUpgradePolicy userLevelUpgradePolicy;
    private User user;

    @Before
    public void setUp() {
        userLevelUpgradePolicy = new CountingBasedUserLevelUpgradePolicy();
        user = new User();
    }

    @Test
    public void upgradeLevel() {
        Level[] levels = Level.values();
        for (Level level : levels) {
            if (level.nextLevel() == null) {
                continue;
            }
            user.setLevel(level);
            userLevelUpgradePolicy.upgradeLevel(user);
            assertThat(user.getLevel(), is(level.nextLevel()));
        }
    }

    @Test(expected = IllegalStateException.class)
    public void cannotUpgradeLevel() {
        Level[] levels = Level.values();
        for (Level level : levels) {
            if (level.nextLevel() != null) {
                continue;
            }
            user.setLevel(level);
            userLevelUpgradePolicy.upgradeLevel(user);
        }
    }

}
