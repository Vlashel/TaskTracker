package com.vlashel.tasktracker.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 30.06.2014.
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Column(unique = true, length = 25)
    private String role;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {}

    public Role(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
