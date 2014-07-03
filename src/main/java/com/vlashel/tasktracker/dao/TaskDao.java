package com.vlashel.tasktracker.dao;

import com.vlashel.tasktracker.model.Task;

import java.util.List;

public interface TaskDao {
	Task getTask(Long id);

    void updateTask(Long id);

    void createTask(Task task);

    void deleteTask(Long id);

    List<Task> getAllTasks(Long id);
}
