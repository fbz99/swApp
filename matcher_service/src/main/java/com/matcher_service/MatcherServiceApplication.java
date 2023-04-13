package com.matcher_service;

import com.matcher_service.db.VectorD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatcherServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MatcherServiceApplication.class, args);
    }

}
