package com.swapp.apigateway.security;
import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class JwtAuthenticationConfig {

    @Value("${private.security.jwt.url:/login}")
    private String url;

    @Value("${private.security.jwt.header:Authorization}")
    private String header;

    @Value("${private.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${private.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${private.security.jwt.secret}")
    private String secret;
}
