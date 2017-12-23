package com.amila.account.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/home")
    public String showResponse(){
        return "Hello SpringBoot Application";
    }
}
