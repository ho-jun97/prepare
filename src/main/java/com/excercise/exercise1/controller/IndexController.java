package com.excercise.exercise1.controller;

import com.excercise.exercise1.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    /**
     * 홈페이지 이동
     * @return home.html 이랑 렌더링
     */
    @GetMapping("/")
    public String home(){
        return "home";
    }

    /**
     * 로그인 페이지로 이동
     * @return login.html 이랑 렌더링
     */
    @GetMapping("/login")
    public String loginForm(){

        return "login";
    }

    /**
     * 로그인한 상태로만 차량 페이지 이동가능
     * 로그인하지 않은 상태로 이동 불가능
     * @param session
     * @return
     */
    @GetMapping("/car")
    public String cars(HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("user");
        // 로그인 안했을 경우 로그인 화면으로 이동
        if(userDto==null){
            return "redirect:/login";
        }
        return "car";
    }
}
