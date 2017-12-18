package ru.housemanagement.model;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;


public class User {
    private String name;
    private String password;
    private int user_id;


    public User() {
    }



    public User(int user_id, String name, String password) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
