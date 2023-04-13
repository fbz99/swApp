package com.registration_service.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Setter
@Getter
@Document
public class user {

    @Id
    private String id;

    @Indexed(unique=true)
    private String email;

    private String password;

    private String name;

    private String surname;

    private Date birthdate;

    @Indexed(unique=true)
    private String username;

}