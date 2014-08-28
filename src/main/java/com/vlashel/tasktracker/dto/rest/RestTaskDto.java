package com.vlashel.tasktracker.dto.rest;

import com.vlashel.tasktracker.model.Task;

import java.util.Date;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 25.08.2014
 */
public class RestTaskDto {
    private String type;
    private String title;
    private String description;
    private Date createdDate;
    private Date finishedDate;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
