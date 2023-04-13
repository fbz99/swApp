package com.swapp.apigateway;

import com.swapp.apigateway.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication ( exclude = {SecurityAutoConfiguration.class} )
@Import(value = {SecurityConfig.class})
@EnableZuulProxy
@EnableFeignClients
public class AuthenticationserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationserviceApplication.class, args);
    }

}
