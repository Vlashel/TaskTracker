package com.vlashel.tasktracker.controller;

import com.vlashel.tasktracker.dao.UserDao;
import com.vlashel.tasktracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 25.08.2014
 */
@Controller
public class AdminController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/admin" , method = RequestMethod.GET)
    public String getUsers(Model model) {

        List<User> userList = userDao.getAllUsers();
        model.addAttribute("userList", userList);
        return "admin";
    }


    @RequestMapping(value = "/delete-user/{id}" , method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {

        userDao.deleteUser(id);

        return "redirect:/admin";
    }
}
