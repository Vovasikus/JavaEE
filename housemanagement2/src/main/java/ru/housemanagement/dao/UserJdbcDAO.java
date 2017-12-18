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

    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, (resultSet, i) -> {
            User user = new User();

            user.setUser_id(resultSet.getInt("user_id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));

            return user;
        });
    }

    public List<User> getAllUsers() {
        String sql = "SELECT user_id, user, password FROM users";
        return  jdbcTemplate.query(sql, (rs, rowNum) -> new User(rs.getInt("user_id"), rs.getString("user"), rs.getString("password")));
    }
}
