package com.registration_service.Exception;

public enum StatusEnumerator {
    //success registration
    OK,
    //user already used
    UAU,
    //email already used
    EAU,
    //invalid password
    IP,
    //invalid mail address
    IMA,
    //missing fields
    MF
}
