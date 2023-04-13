package com.swapp.apigateway.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


public class JwtAuthorizationFilter extends OncePerRequestFilter {


    private String jwt_secret;
    JwtAuthorizationFilter(String jwt_secret){
        this.jwt_secret=jwt_secret;
    }
    public String checkToken(String token) {
        try {
            System.out.println("AuthorizationFilter: validating jwt with secret: "+jwt_secret);
            Claims claims = Jwts.parser()
                    .setSigningKey(jwt_secret.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();
            if (username != null) {
                return username;
            }

        } catch (Exception ignore) {
            return null;
        }
        return null;
    }

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain chain)
                throws ServletException, IOException {
            // Get authorization header and validate
            final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (header == null && request.getRequestURI().equals("/registration/submit")) {
                HeaderMapRequestWrapper headerMapRequestWrapper = new HeaderMapRequestWrapper((HttpServletRequest) request);
                chain.doFilter(headerMapRequestWrapper,response);
                return;
            }
            System.out.println("AuthorizationFilter: "+header);
            if (!header.startsWith("Bearer ")){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            // Get jwt token and validate
            final String token = header.split(" ")[1].trim();
            String username;
            if ((username = checkToken(token)) == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            HeaderMapRequestWrapper headerMapRequestWrapper = new HeaderMapRequestWrapper((HttpServletRequest) request);
            headerMapRequestWrapper.addHeader("username",username);
            System.out.println("username: "+username);
            chain.doFilter(headerMapRequestWrapper,response);
        }
}
