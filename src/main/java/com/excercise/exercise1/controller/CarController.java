package com.excercise.exercise1.controller;

import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.UserDto;
import com.excercise.exercise1.service.CarService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    final private CarService carService;

    /**
     * 자신이 보유한 차량리스트 or 자신이 보유한 차량 and 뒷자리 4자리 번호 맞는 리스트 뽑아내는 메소드
     * @param session = user 뽑기위해서
     * @param target = 차량번호검색(default: "")
     * @return 차량 목록 리스트
     */
    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> findCars(HttpSession session, @RequestParam(defaultValue = "")  String target){
        UserDto userDto = (UserDto) session.getAttribute("user");
        List<CarDto> list = carService.findCarList(userDto, target);
        return ResponseEntity.ok(list);
    }
}
