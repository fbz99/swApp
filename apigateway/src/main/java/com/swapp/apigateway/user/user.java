package com.swapp.apigateway.user;
import javax.validation.constraints.NotNull;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Document
public class user {

	@NotNull
	@Indexed(unique=true)
	private String email;

	@NotNull
	private String password;

	@NotNull
	private String username;


	public String getEmail() {
		return email;
	}

	public String getUsername(){return username;}
	public String getPassword() {
		return password;
	}

	
	
}


