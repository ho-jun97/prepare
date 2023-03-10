package com.excercise.exercise1.controller;

import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.UserDto;
import com.excercise.exercise1.service.CarService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public @ResponseBody ResponseEntity<List<CarDto>> findCars(HttpSession session, @RequestParam(defaultValue = "")  String target){
        UserDto userDto = (UserDto) session.getAttribute("user");
        List<CarDto> carList = carService.findCarList(userDto, target);
        return ResponseEntity.ok(carList);
    }

    /**
     * 차량 등록하는 메소드
     * @param session
     * @param carDto
     * @return 차량 등록하고 홈으로 이동
     */
    @PostMapping("/carAdd")
    public String addCar(HttpSession session, @ModelAttribute CarDto carDto){
        UserDto userDto = (UserDto) session.getAttribute("user");
        carService.addCar(userDto,carDto);

        return "redirect:/";
    }

    /**
     * 해당 차량의 정보들을 수정하는 메소드
     * @param carId
     * @param carDto
     * @return 차량 수정하고 목록으로 이동
     */
    @PostMapping("/carUpdate/{id}")
    public String updateCar(@PathVariable("id") Long carId, @ModelAttribute CarDto carDto){
        carService.updateCar(carId, carDto);
        return "redirect:/car";
    }
}
