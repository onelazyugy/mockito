package com.le.viet.mockito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private static ApplicationContext context;

    public static void main(String[] args) {
        LOG.debug("STARTED: main");
        context = SpringApplication.run(Application.class, args);
        LOG.debug("END: main...application started successfully!");
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        Application.context = context;
    }
}