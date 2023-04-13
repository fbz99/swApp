package com.registration_service.controller;
import com.registration_service.Exception.StatusEnumerator;
import com.registration_service.service.RegistrationService;
import com.registration_service.user.user;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService service;

    @PostMapping("/submit")
    public void CreateUser(@Valid @RequestBody user newuser, HttpServletResponse response) throws IOException {
        StatusEnumerator status = service.CreateUser(newuser);
        if(status != StatusEnumerator.OK) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,getMessage(status));
            }

        response.setStatus(HttpServletResponse.SC_OK);
        // il codice sottostante non è una soluzione ottimale. Sarebbe buona pratica far comunicare i microservizi con una coda asincrona.
        // inoltre bisogna capire il concetto di multithreading all'interno del framework spring: in questo modo la chiamata è veramente non bloccante? BOH
     /*   new Thread() {
            @Override
            public void run() {
                emailInterface.sendemail(newuser.getUsername()+" "+newuser.getEmail());
            }
        }.start();*/

    }

    private String getMessage(StatusEnumerator e){
        switch (e) {
            case IP -> {
                return "Password is invalid: must be at least 8 characters";
            }
            case EAU -> {
                return "mail address is already in use";
            }
            case IMA -> {
                return "invalid mail address";
            }
            case UAU -> {
                return "username is already in use";
            }
            case MF -> {
                return "missing mandatory fields";
            }
        }
        return "";
    }
}
