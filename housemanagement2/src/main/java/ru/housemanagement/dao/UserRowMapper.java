package ru.housemanagement.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.housemanagement.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setName(resultSet.getString("user"));
        user.setPassword(resultSet.getString("password"));
        user.setFlatnumber_id(resultSet.getInt("flatnumber_id"));

        return user;
    }
}
