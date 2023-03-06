package com.excercise.exercise1.controller;

import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.service.CarService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    final private CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> findCars(HttpSession session, @RequestParam(defaultValue = "")  String target){
        System.out.println("Target : " + target);

        // 차량 목록 조회
        List<CarDto> list = carService.findCarList(session, target);

        return ResponseEntity.ok(list);
    }
}
