package com.project.codechecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CodeCheckerApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(CodeCheckerApplication.class);

    public static void main(String[] args) {
        try {
            logger.info("Starting CodeChecker Application...");
            SpringApplication.run(CodeCheckerApplication.class, args);
            logger.info("Application started successfully!");
        } catch (Exception e) {
            logger.error("Failed to start application", e);
            throw e;
        }
    }
}
