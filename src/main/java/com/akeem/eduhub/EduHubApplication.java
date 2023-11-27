package com.akeem.eduhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EduHubApplication {


    public static void main(String[] args)  {
        ConfigurableApplicationContext  context =SpringApplication.run(EduHubApplication.class, args);
    }
}