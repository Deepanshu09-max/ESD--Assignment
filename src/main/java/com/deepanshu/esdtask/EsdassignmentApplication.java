package com.deepanshu.esdtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude ={SecurityAutoConfiguration.class} )
public class EsdassignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsdassignmentApplication.class, args);
    }

}
