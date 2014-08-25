package com.vlashel.tasktracker.dto;


import com.vlashel.tasktracker.model.Task;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 02.07.2014.
 */
public class TaskDto {

    private Task.Type type;
    private String title;
    private String description;

    public Task.Type getType() {
        return type;
    }

    public void setType(Task.Type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
