package com.excercise.exercise1.controller;

import com.excercise.exercise1.domain.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String loginForm(){

        return "login";
    }

    @GetMapping("/car")
    public String cars(){
        return "car";
    }
}
