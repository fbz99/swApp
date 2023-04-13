package com.registration_service.service;

import com.registration_service.Exception.StatusEnumerator;
import com.registration_service.user.user;
import com.registration_service.user.userRepo;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
@Component
@Service
public class RegistrationService {

    @Autowired
    private userRepo userepo;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public boolean checkFields(user NewUser){
        return NewUser.getBirthdate() != null && NewUser.getName() != null && NewUser.getEmail() != null && NewUser.getSurname() != null && NewUser.getPassword() != null && NewUser.getUsername() != null;
    }
    public StatusEnumerator CreateUser(@Valid user NewUser) {
        if (!checkFields(NewUser)) return StatusEnumerator.MF;
        if (userepo.findByEmail(NewUser.getEmail())!=null) return StatusEnumerator.EAU;
        if (userepo.findByUsername(NewUser.getUsername())!=null) return StatusEnumerator.UAU;
        if ( !EmailValidator.getInstance().isValid(NewUser.getEmail()) ) return StatusEnumerator.IMA;
        NewUser.setPassword(encriptedPassword(NewUser.getPassword()));
        userepo.save(NewUser);
        return StatusEnumerator.OK;
    }

    //  getUser probabilmente non serve a nulla
    public user getUser(String email){
       return userepo.findByEmail(email);
    }

    // da chiamare una volta capito come far comunicare i microservizi
    public user ChangePasswordToUser(@Valid user user){
        user.setId(userepo.findByEmail(user.getEmail()).getId());
        user.setPassword(encriptedPassword(user.getPassword()));
       return userepo.save(user);
    }

    public String encriptedPassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

}

