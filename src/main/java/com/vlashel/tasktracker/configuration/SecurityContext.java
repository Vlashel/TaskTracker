package com.vlashel.tasktracker.configuration;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 15.09.2014
 */

@Configuration
@EnableWebSecurity
public class SecurityContext extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService customUserDetailsService;


    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/login/").access("hasRole('ROLE_ANONYMOUS')")
                .antMatchers("/loginfailed").access("hasRole('ROLE_ANONYMOUS')")
                .antMatchers("/new-task").access("hasRole('ROLE_USER')")
                .antMatchers("/task").access("hasRole('ROLE_USER')")
                .antMatchers("/task-list").access("hasRole('ROLE_USER')")
                .antMatchers("/").permitAll()
                .and().formLogin()
                .usernameParameter("j_username") // default is username
                .passwordParameter("j_password") // default is password
                .loginPage("/login") // default is /login with an HTTP get
                .failureUrl("/loginfailed")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");


    }

}
