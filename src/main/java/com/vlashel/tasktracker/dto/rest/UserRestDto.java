package com.vlashel.tasktracker.dto.rest;

import java.util.Date;
import java.util.List;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 26.08.2014
 */
public class UserRestDto {

    private Long id;
    private String name;
    private String password;
    private List<Long> tasks;
    private Date registrationDate;

    public List<Long> getTasks() {
        return tasks;
    }

    public void setTasks(List<Long> tasks) {
        this.tasks = tasks;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
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
}
