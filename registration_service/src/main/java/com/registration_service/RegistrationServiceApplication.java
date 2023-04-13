package com.registration_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication ( exclude = {SecurityAutoConfiguration.class} )

public class RegistrationServiceApplication {
    @Value("${cacca}")
    private static String dio;
    public static void main(String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
        System.out.println(dio);
    }

}
