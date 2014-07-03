package com.vlashel.tasktracker.service;

import com.vlashel.tasktracker.dao.UserDao;
import com.vlashel.tasktracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 02.07.2014.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public User getCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userDao.getUserByName(name);
    }
}
