package ru.housemanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.housemanagement.model.User;

import java.util.List;

@Repository
public class UserJdbcDAO implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO users(user, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[] {user.getName(), user.getPassword()});
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT flatnumber_id, user, password FROM users";
        return  jdbcTemplate.query(sql, new UserRowMapper());
    }
}
