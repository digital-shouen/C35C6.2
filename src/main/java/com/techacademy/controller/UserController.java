package com.techacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UserController {

    @GetMapping("/")
    public String index() {
        return "Hello SpringBoot!";
    }
}
