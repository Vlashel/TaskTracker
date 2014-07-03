package com.vlashel.tasktracker.dto;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 30.06.2014.
 */

public class UserDto {

    private String name;
    private String password;

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
}
