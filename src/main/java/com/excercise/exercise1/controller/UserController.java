package com.excercise.exercise1.controller;

import com.excercise.exercise1.domain.user.User;
import com.excercise.exercise1.dto.LoginDto;
import com.excercise.exercise1.dto.UserDto;
import com.excercise.exercise1.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    final private UserService userService;
    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, HttpSession session){
        // true : 로그인 성공 , false : 로그인 실패
        if(!userService.checkLogin(loginDto)){
            return "redirect:/login";
        }
        User user = userService.findByUsername(loginDto.getUsername()); // 로그인 user 불러오기
        UserDto userDto = UserDto.of(user.getId(), user.getUsername());
        session.setAttribute("user", userDto);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


}
