package com.vlashel.tasktracker.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false)
    private final Date registrationDate = new Date();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user" , fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Task> tasks = new ArrayList<Task>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="user_roles",
            joinColumns={@JoinColumn(name="userId", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="roleId", referencedColumnName="id")}
    )
    private List<Role> roles = new ArrayList<>();

    public User() {


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {

        User user  = (User) obj;

        if (this.getId().equals(user.getId())) {
            return true;
        }

        return false;
    }
}