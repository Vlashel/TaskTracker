package com.vlashel.tasktracker.controller;

import com.vlashel.tasktracker.dao.RoleDao;
import com.vlashel.tasktracker.dao.UserDao;
import com.vlashel.tasktracker.dto.UserDto;
import com.vlashel.tasktracker.model.User;
import com.vlashel.tasktracker.service.PasswordEncoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 06.06.2014.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoderService passwordEncoderService;

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute(userDto);
        return "registration-form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String receiveForm(@ModelAttribute("userDto") UserDto userDto) {

        User user = new User();

        user.setName(userDto.getName());
        user.setPassword(passwordEncoderService.encodePassword(userDto.getPassword()));
        user.addRole(roleDao.getByName("ROLE_USER"));

        userDao.createUser(user);
        return "redirect:/login";
    }
}
