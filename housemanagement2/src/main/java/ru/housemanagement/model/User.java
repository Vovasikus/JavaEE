package ru.housemanagement.model;

public class User {
    private String name;
    private String password;
    private int flatnumber_id;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.flatnumber_id = flatnumber_id;
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

    public int getFlatnumber_id() {
        return flatnumber_id;
    }

    public void setFlatnumber_id(int flatnumber_id) {
        this.flatnumber_id = flatnumber_id;
    }
}
