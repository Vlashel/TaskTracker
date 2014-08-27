package com.vlashel.tasktracker.model;



import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tasks")

public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private String title;

    private String type;

    private String description;
    private final Date createdDate = new Date();
    private Date finishedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", finishedDate=" + finishedDate +
                '}';
    }


    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Task task = (Task) obj;

        if (task.getId() != this.getId()){
            return false;
        }
/*
        if (task.getTitle() != this.getTitle()) {
            return false;
        }

        if (task.getDescription() != this.getDescription()) {
            return false;
        }

        if (task.getCreatedDate() != this.getCreatedDate()) {
            return false;
        }

        if (task.getFinishedDate() != this.getFinishedDate()) {
            return false;
        }*/


        return true;
    }

    public enum Type {
        Adventure, Holiday, Relationship, Work, Goal, Meeting, Other
    }

}


