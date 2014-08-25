package com.vlashel.tasktracker.controller;

import com.vlashel.tasktracker.dao.TaskDao;
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

import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping(value = "/new-task", method = RequestMethod.GET)
    public String getTaskForm(Model model) {
        TaskDto taskDto = new TaskDto();
        List<Task.Type> options = new ArrayList<>();

        for (Task.Type type : Task.Type.values()) {
            options.add(type);
        }

        model.addAttribute("options", options);

        model.addAttribute(taskDto);
        return "task-form";

    }
    @RequestMapping(value = "/new-task", method = RequestMethod.POST)
    public String receiveTaskForm(@ModelAttribute("taskDto") TaskDto taskDto) {
        User user = userService.getCurrentUser();
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setType(taskDto.getType().toString());
        task.setDescription(taskDto.getDescription());
        task.setUser(user);
        taskDao.createTask(task);

        return "redirect:/task-list";
    }

    @RequestMapping(value = "/task-list", method = RequestMethod.GET)
    public String getTaskList(Model model) {

        Long id = userService.getCurrentUser().getId();
        List<Task> taskList = taskDao.getAllTasks(id);

        model.addAttribute("taskList", taskList);
        return "task-list";

    }

    @RequestMapping(value = "/delete-task/{id}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable Long id) {

        taskDao.deleteTask(id);

        return "redirect:/task-list";
    }
    @RequestMapping(value = "/finish-task/{id}", method = RequestMethod.GET)
    public String updateFinishedTask(@PathVariable Long id) {

        Task task = taskDao.getTask(id);

        task.setFinishedDate(new Date());

        taskDao.updateTask(task);

        return "redirect:/task-list";
    }


    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public String getTask(@PathVariable Long id, Model model) {

        Task task = taskDao.getTask(id);

        model.addAttribute("task", task);
        return "task-view";

    }
}
