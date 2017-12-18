package ru.housemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.housemanagement.dao.UserJdbcDAO;
import ru.housemanagement.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserJdbcDAO userJdbcDAO;

    public User getUserById(int id) { return userJdbcDAO.getUserById(id); }
    public List<User> getAllUsers() {
        return userJdbcDAO.getAllUsers();
    }

}
