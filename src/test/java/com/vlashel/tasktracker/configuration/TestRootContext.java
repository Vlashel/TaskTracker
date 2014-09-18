package com.vlashel.tasktracker.configuration;

import com.vlashel.tasktracker.dao.RoleDao;
import com.vlashel.tasktracker.dao.TaskDao;
import com.vlashel.tasktracker.dao.UserDao;
import com.vlashel.tasktracker.model.Task;
import com.vlashel.tasktracker.service.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 17.09.2014
 */
@Configuration
@ComponentScan(basePackages =
        {"com.vlashel.tasktracker.service",
                "com.vlashel.tasktracker.dto"
        }, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {UserService.class})})
public class TestRootContext {

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }

    @Bean
    public TaskDao taskDao() {
        return Mockito.mock(TaskDao.class);
    }

    @Bean
    public UserDao userDao() {
        return Mockito.mock(UserDao.class);
    }

    @Bean
    public RoleDao roleDao() {
        return Mockito.mock(RoleDao.class);
    }

}
