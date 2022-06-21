package dev.ohhhmycode.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 김동욱, dongwook_@a2dcorp.co.kr
 * @version 1.0
 * @since 2022-06-21
 */
public class NUserDao extends AbstractUserDao {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springtobybook", "spring", "book");
        return c;
    }

}
