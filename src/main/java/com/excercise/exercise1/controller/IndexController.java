package com.excercise.exercise1.controller;

import com.excercise.exercise1.domain.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // 홈(처음)페이지
    @GetMapping("/")
    public String home(){
        return "home";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String loginForm(){

        return "login";
    }

    // 차량 검색 목록 페이지
    @GetMapping("/car")
    public String cars(){
        return "car";
    }
}
