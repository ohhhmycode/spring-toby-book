package dev.ohhhmycode.user.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

//@Configuration
public class DaoFactory {

//    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

//    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/springtobybook");
        dataSource.setUsername("spring");
        dataSource.setPassword("book");

        return dataSource;
    }

}
