package dev.ohhhmycode.user.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import dev.ohhhmycode.user.domain.User;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user1 = new User("tester01", "테스터01", "t1-1234");
        User user2 = new User("tester02", "테스터02", "t2-1234");

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassword(), is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());
        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassword(), is(user2.getPassword()));
    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        User user1 = new User("tester01", "테스터01", "t1-1234");
        User user2 = new User("tester02", "테스터02", "t2-1234");
        User user3 = new User("tester03", "테스터03", "t3-1234");

        UserDao dao = context.getBean("userDao", UserDao.class);

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        assertThat(dao.getCount(), is(1));

        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void getUserFailure() throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("unknown_id");
    }

}
