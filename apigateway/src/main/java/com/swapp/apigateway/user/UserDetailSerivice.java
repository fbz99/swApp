package com.swapp.apigateway.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailSerivice implements UserDetailsService{
	
	  @Autowired
	  private UserRepo repository;  
	  @Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  System.out.println("login - username: "+ username);
		  
	    user user = repository.findByUsername(username); 

	    if(user == null ) {
			if((user = repository.findByEmail(username)) == null) {
				System.out.println("User not found");
				throw new UsernameNotFoundException("User not found");
			}
		}

	    return new CustomUserDetails(user);
	  }


	}

