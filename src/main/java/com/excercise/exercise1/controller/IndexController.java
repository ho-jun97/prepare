package com.excercise.exercise1.controller;

import com.excercise.exercise1.domain.car.Car;
import com.excercise.exercise1.domain.user.User;
import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.UserDto;
import com.excercise.exercise1.service.CarService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    final private CarService carService;
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
    public String cars(Model model, HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("user");
        // 로그인 안했을 경우 로그인 화면으로 이동
        if(userDto==null){
            return "redirect:/login";
        }
        return "car";
    }

    @GetMapping("/map")
    public String map(Model model, @RequestParam Long id){
        System.out.println("ID : "+ id);

        // id로 차량 정보 가져오기
        Car car = carService.findById(id);
        if(car == null){
            return "redirect:/cars";
        }

        // 차량이랑 연결된 위치정보 가져오기
        String lat = car.getLocation().getLat();
        String lng = car.getLocation().getLng();

        model.addAttribute("lat", lat);
        model.addAttribute("lng", lng);

        return "map";
    }
}
