package com.vlashel.tasktracker.dao;

import com.vlashel.tasktracker.model.Role;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 30.06.2014.
 */

public interface RoleDao {

    Role getById(Integer id);

    Role getByName(String role);
}
