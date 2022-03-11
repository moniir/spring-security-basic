package com.example.springsecurityexample.demo.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noAuth/rest")
public class NoAuthController {

    @GetMapping("/home")
    private String getMessage(){
        return "Hello controller";
    }
}
