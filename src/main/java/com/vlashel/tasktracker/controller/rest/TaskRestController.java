package com.vlashel.tasktracker.controller.rest;

import com.vlashel.tasktracker.dao.TaskDao;
import com.vlashel.tasktracker.dto.TaskDto;
import com.vlashel.tasktracker.dto.rest.RestTaskDto;
import com.vlashel.tasktracker.model.Task;
import com.vlashel.tasktracker.model.User;
import com.vlashel.tasktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 25.08.2014
 */
@RestController
@RequestMapping(value = "/rest")
public class TaskRestController {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/new-task", method = RequestMethod.POST, produces = "application/json")
    public Task receiveTaskForm(@RequestBody TaskDto taskDto) {
        User user = userService.getCurrentUser();
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setType(taskDto.getType().toString());
        task.setDescription(taskDto.getDescription());
        task.setUser(user);
        taskDao.createTask(task);

        return task;
    }

    @RequestMapping(value = "/task-list", method = RequestMethod.GET, produces = "application/json")
    public List<RestTaskDto> getTaskList() {

        Long id = userService.getCurrentUser().getId();
        List<Task> taskList = taskDao.getAllTasks(id);
        List<RestTaskDto> restTaskDtoList = new ArrayList<>();

        for (Task task : taskList) {
            RestTaskDto restTaskDto = new RestTaskDto();

            restTaskDto.setType(task.getType());
            restTaskDto.setTitle(task.getTitle());
            restTaskDto.setDescription(task.getDescription());
            restTaskDto.setCreatedDate(task.getCreatedDate());
            restTaskDto.setFinishedDate(task.getFinishedDate());
            restTaskDto.setUserId(task.getUser().getId());

            restTaskDtoList.add(restTaskDto);
        }
        return restTaskDtoList;
    }

    @RequestMapping(value = "/delete-task/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable Long id) {
        taskDao.deleteTask(id);
    }
    @RequestMapping(value = "/finish-task/{id}", method = RequestMethod.PUT)
    public void updateFinishedTask(@PathVariable Long id) {

        Task task = taskDao.getTask(id);

        task.setFinishedDate(new Date());

        taskDao.updateTask(task);
    }


    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET, produces = "application/json")
    public RestTaskDto getTask(@PathVariable Long id) {

        Task task = taskDao.getTask(id);

        RestTaskDto restTaskDto = new RestTaskDto();

        restTaskDto.setType(task.getType());
        restTaskDto.setTitle(task.getTitle());
        restTaskDto.setDescription(task.getDescription());
        restTaskDto.setCreatedDate(task.getCreatedDate());
        restTaskDto.setFinishedDate(task.getFinishedDate());
        restTaskDto.setUserId(task.getUser().getId());

        return restTaskDto;

    }
}
