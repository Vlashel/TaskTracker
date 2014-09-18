package com.vlashel.tasktracker.util;

import com.vlashel.tasktracker.model.Task;
import com.vlashel.tasktracker.model.User;

import java.util.Date;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 17.09.2014
 */
public class TaskBuilder {

    private Long id;
    private User user;
    private String title;
    private String type;
    private String description;
    private Date finishedDate;


    public TaskBuilder id(Long id) {
        this.id = id;
        return this;
    }


    public TaskBuilder user(User user) {
        this.user = user;
        return this;
    }


    public TaskBuilder title(String title) {
        this.title = title;
        return this;
    }


    public TaskBuilder type(String type) {
        this.type = type;
        return this;
    }


    public TaskBuilder description(String description) {
        this.description = description;
        return this;
    }


    public TaskBuilder finishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
        return this;
    }

    public Task build() {

        Task task = new Task();
        task.setId(id);
        task.setUser(user);
        task.setFinishedDate(finishedDate);
        task.setDescription(description);
        task.setTitle(title);
        task.setType(type);

        return task;

    }
}
