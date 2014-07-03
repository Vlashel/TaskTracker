package com.vlashel.tasktracker.dao;

import com.vlashel.tasktracker.model.User;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 06.06.2014.
 */
public interface UserDao {
    User getUserById(Long id);

    User getUserByName(String name);

    void updateUser(User user);

    void createUser(User user);

    void deleteUser(Long id);
}
