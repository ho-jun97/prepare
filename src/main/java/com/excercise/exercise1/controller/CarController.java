package com.excercise.exercise1.controller;

import com.excercise.exercise1.domain.user.User;
import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.UserDto;
import com.excercise.exercise1.service.CarService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {

    final private CarService carService;

    @GetMapping("/cars")
    public String findCars(HttpSession session, @RequestParam String target){

        UserDto userDto = (UserDto) session.getAttribute("user");
        // 로그인하지 않은 상태로 접근했을 때 로그인화면으로 이동
        if(userDto == null){
            return "redirect:/login";
        }
        // user가 보유한 차량 리스트 불러오기(차량의 뒷자리 4자리로 검색)
        List<CarDto> list = carService.findCarList(userDto, target);

//        System.out.println("size : " + list.size());
//        for (CarDto car:
//             list) {
//            System.out.println(car);
//        }
        return "redirect:/";
    }
}
