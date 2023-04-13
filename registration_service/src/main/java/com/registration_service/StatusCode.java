package com.registration_service;


public enum StatusCode {
    //SUCCESS REGISTRATION
    OK,
    //EMAIL ALREADY USED
    EAU,
    //USERNAME ALREADY USED
    UAU,
    //MISSING FIELDS
    MF,
    //INVALID PASSWORD
    IP,
    //INAVLID MAIL ADDRESS
    IMA
}
