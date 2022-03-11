package com.example.springsecurityexample.demo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class HomeController {


    @GetMapping("/")
    private String getHi(){
        return "Hi hi controller";
    }
}
