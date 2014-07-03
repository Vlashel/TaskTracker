package com.vlashel.tasktracker.controller;

import com.vlashel.tasktracker.dao.TaskDao;
import com.vlashel.tasktracker.dao.UserDao;
import com.vlashel.tasktracker.dto.TaskDto;
import com.vlashel.tasktracker.model.Task;
import com.vlashel.tasktracker.model.User;
import com.vlashel.tasktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 02.07.2014.
 */
@Controller
public class TaskController {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/new-task", method = RequestMethod.GET)
    public String getTaskForm(Model model) {
        TaskDto taskDto = new TaskDto();
        model.addAttribute(taskDto);
        return "task-form";
    }
    @RequestMapping(value = "/new-task", method = RequestMethod.POST)
    public String receiveTaskForm(@ModelAttribute("taskDto") TaskDto taskDto) {
        User user = userService.getCurrentUser();
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setType(taskDto.getType());
        task.setDescription(taskDto.getDescription());
        task.setUser(user);
        taskDao.createTask(task);
        user.addTask(task);
        userDao.updateUser(user);

        return "redirect:/task-list";
    }

    @RequestMapping(value = "/task-list", method = RequestMethod.GET)
    public String getTaskList(Model model) {

        Long id = userService.getCurrentUser().getId();
        List<Task> taskList = taskDao.getAllTasks(id);



        model.addAttribute("taskList", taskList);
        return "task-list";

    }

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String getTask(@PathVariable Long id, Model model) {

        List<Task> taskList = taskDao.getAllTasks(id);


        model.addAttribute("taskList", taskList);
        return "task";

    }
}
