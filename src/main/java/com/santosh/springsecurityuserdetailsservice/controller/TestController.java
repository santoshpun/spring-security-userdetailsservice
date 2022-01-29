package com.santosh.springsecurityuserdetailsservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping(value = "admin/welcome")
    public String welcomeAdmin() {
        return "Welcome Admin !";
    }

    @GetMapping(value = "dashboard")
    public String welcomeUser() {
        return "Welcome to Dashboard !";
    }

    @GetMapping("public/welcome")
    public String welcome() {
        return "Welcome page !";
    }

    @GetMapping(value = "public/hello")
    public String hello() {
        return "Hello visitor !";
    }
}
