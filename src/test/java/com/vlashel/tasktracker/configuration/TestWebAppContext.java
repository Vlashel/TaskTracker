package com.vlashel.tasktracker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/**
 * @author Vladyslav Shelest
 * @version 1.0
 * @since 17.09.2014
 */
@Configuration
@ComponentScan("com.vlashel.tasktracker.controller")
@EnableWebMvc
public class TestWebAppContext extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //registry.tiles();
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    /*@Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/tiles-definitions.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }*/

}
