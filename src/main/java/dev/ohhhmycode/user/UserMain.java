package dev.ohhhmycode.user;

import dev.ohhhmycode.user.dao.UserDao;
import dev.ohhhmycode.user.domain.User;
import java.sql.SQLException;

/**
 * @author 김동욱, dongwook_@a2dcorp.co.kr
 * @version 1.0
 * @since 2022-06-20
 */
public class UserMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("ohhhmycode");
        user.setName("Dongwook");
        user.setPassword("studying..");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }

}
