package dev.ohhhmycode.user.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import dev.ohhhmycode.user.domain.User;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/test-applicationContext.xml" })
public class UserDaoTest {

//    @Autowired
    private UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        DataSource dataSource = new SingleConnectionDataSource(
            "jdbc:mysql://localhost/springtobybook_test", "spring", "book", true);
        JdbcContext jdbcContext = new JdbcContext();
        jdbcContext.setDataSource(dataSource);

        dao = new UserDao();
        dao.setDataSource(dataSource);

        user1 = new User("tester01", "테스터01", "t1-1234");
        user2 = new User("tester02", "테스터02", "t2-1234");
        user3 = new User("tester03", "테스터03", "t3-1234");
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
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
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("unknown_id");
    }

}
