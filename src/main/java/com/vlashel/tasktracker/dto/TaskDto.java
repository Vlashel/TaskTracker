package com.vlashel.tasktracker.dto;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 02.07.2014.
 */
public class TaskDto {

    private String type;
    private String name;
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
