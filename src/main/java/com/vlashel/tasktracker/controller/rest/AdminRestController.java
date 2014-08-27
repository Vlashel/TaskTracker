package com.vlashel.tasktracker.controller.rest;

import com.vlashel.tasktracker.dao.UserDao;
import com.vlashel.tasktracker.dto.rest.UserRestDto;
import com.vlashel.tasktracker.model.Task;
import com.vlashel.tasktracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 26.08.2014
 */
@RestController
@RequestMapping(value = "/admin/rest")
public class AdminRestController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user-list", method = RequestMethod.GET, produces = "application/json")
    public List<UserRestDto> getUsers() {

        List<User> userList = userDao.getAllUsers();
        List<UserRestDto> userRestDtos = new ArrayList<>();

        for (User user : userList) {
            UserRestDto userRestDto = new UserRestDto();
            userRestDto.setId(user.getId());
            userRestDto.setName(user.getName());
            userRestDto.setPassword(user.getPassword());
            userRestDto.setRegistrationDate(user.getRegistrationDate());

            List<Long> taskIds = new ArrayList<>();

            for (Task task : user.getTasks()) {
                taskIds.add(task.getId());
            }

            userRestDto.setTasks(taskIds);

            userRestDtos.add(userRestDto);
        }

        return userRestDtos;
    }


    @RequestMapping(value = "/delete-user/{id}" , method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {

        userDao.deleteUser(id);

    }
}
