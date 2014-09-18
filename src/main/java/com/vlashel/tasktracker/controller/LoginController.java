package com.vlashel.tasktracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 30.06.2014.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login-form";
    }
    @RequestMapping(value = "/login-failed", method = RequestMethod.GET)
    public String getLoginPageFailure(Model model) {
        model.addAttribute("message", "Incorrect name or password");
        return "login-form";
    }
}
