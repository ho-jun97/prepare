package com.excercise.exercise1.controller;

import com.excercise.exercise1.dto.LoginDto;
import com.excercise.exercise1.dto.UserDto;
import com.excercise.exercise1.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    final private UserService userService;

    /**
     * 로그인 메소드
     * @param loginDto username, password
     * @param session 로그인한 상태를 유지하기 위한 파라미터
     * @return 로그인 성공시 홈으로, 실패시 로그인 페이지로
     */
    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, HttpSession session){
        // true : 로그인 성공 , false : 로그인 실패
        if(!userService.checkLogin(loginDto)){
            return "redirect:/login";
        }
        // user 정보 불러오기
        UserDto userDto = userService.getUser(loginDto.getUsername());
        // session에 저장
        session.setAttribute("user", userDto);
        return "redirect:/";
    }

    /**
     * 로그아웃 : 세션에서 유저정보 제거
     * @param session
     * @return 홈으로 렌더링
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
