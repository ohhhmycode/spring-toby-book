package dev.ohhhmycode.user.domain;

public class User {
    String id;
    String name;
    String password;
    Level level;
    String email;
    int login;
    int recommend;

    public User () {
    }

    public User (String id, String name, String password, Level level, String email, int login, int recommend) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
        this.email = email;
        this.login = login;
        this.recommend = recommend;
    }

    public void upgradeLevel() {
        Level nextLevel = getLevel().nextLevel();
        if (nextLevel == null) {
            throw new IllegalStateException(getLevel() + "은 업그레이드가 불가능합니다.");
        }
        setLevel(nextLevel);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

}
