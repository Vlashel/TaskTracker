package com.vlashel.tasktracker.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 16.09.2014
 */
@Configuration
@ComponentScan(basePackages =
        {"com.vlashel.tasktracker.dao",
        "com.vlashel.tasktracker.service",
        "com.vlashel.tasktracker.model",
        "com.vlashel.tasktracker.dto"
})
public class RootContext {


}
