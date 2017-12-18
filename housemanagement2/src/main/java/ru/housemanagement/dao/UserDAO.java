package ru.housemanagement.dao;

import ru.housemanagement.model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    List<User> getAllUsers();
}
