package com.vlashel.tasktracker.controller;

import com.vlashel.tasktracker.configuration.TestDatabaseContext;
import com.vlashel.tasktracker.configuration.TestRootContext;
import com.vlashel.tasktracker.configuration.TestSecurityContext;
import com.vlashel.tasktracker.configuration.TestWebAppContext;
import com.vlashel.tasktracker.dao.TaskDao;
import com.vlashel.tasktracker.model.Task;
import com.vlashel.tasktracker.model.User;
import com.vlashel.tasktracker.service.UserService;
import com.vlashel.tasktracker.util.TaskBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;


import java.util.Arrays;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 15.09.2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestRootContext.class, TestWebAppContext.class})
@WebAppConfiguration
public class TaskControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private TaskDao taskDaoMock;

    @Autowired
    private UserService userService;


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getTaskList_shouldAddTasksToModelAndReturnTaskListView() throws Exception {

        User user = new User();
        user.setId(1L);
        user.setName("vlashel");

        when(userService.getCurrentUser()).thenReturn(user);


        Task task1 = new TaskBuilder()
                .id(1L)
                .description("task1 description")
                .title("Task1 Title")
                .type("adventure")
                .build();

        Task task2 = new TaskBuilder()
                .id(2L)
                .description("task2 description")
                .title("Task2 Title")
                .type("adventure")
                .build();

        when(taskDaoMock.getAllTasks(anyLong())).thenReturn(Arrays.asList(task1, task2));

        mockMvc.perform(MockMvcRequestBuilders.get("/task-list"))
                .andExpect(status().isOk())
                .andExpect(view().name("task-list"))
                .andExpect(model().attribute("taskList", hasSize(2)))
                .andExpect(model().attribute("taskList", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("description", is("task1 description")),
                                hasProperty("title", is("Task1 Title")),
                                hasProperty("type", is("adventure"))
                        )

                )))
                .andExpect(model().attribute("taskList", hasItem(
                        allOf(
                                hasProperty("id", is(2L)),
                                hasProperty("description", is("task2 description")),
                                hasProperty("title", is("Task2 Title")),
                                hasProperty("type", is("adventure")))
                )));

        verify(taskDaoMock, times(1)).getAllTasks(anyLong());
        verifyNoMoreInteractions(taskDaoMock);

    }


    @After
    public void tearDown() {
        reset(userService);
        reset(taskDaoMock);
    }

}
