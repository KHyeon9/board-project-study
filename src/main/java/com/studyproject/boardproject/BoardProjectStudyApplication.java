package com.studyproject.boardproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BoardProjectStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardProjectStudyApplication.class, args);
    }

}
