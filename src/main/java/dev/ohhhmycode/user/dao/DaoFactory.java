package dev.ohhhmycode.user.dao;

/**
 * @author 김동욱, dongwook_@a2dcorp.co.kr
 * @version 1.0
 * @since 2022-06-23
 */
public class DaoFactory {

    public UserDao userDao() {
        ConnectionMaker connectionMaker = connectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    private ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

}
