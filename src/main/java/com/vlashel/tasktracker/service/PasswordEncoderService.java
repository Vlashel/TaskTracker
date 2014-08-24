package com.vlashel.tasktracker.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 24.08.2014
 */
@Service
public class PasswordEncoderService {

    public String encodePassword(String password) {

        String encodedPassword = new BCryptPasswordEncoder().encode(password);

        return encodedPassword;
    }
}
