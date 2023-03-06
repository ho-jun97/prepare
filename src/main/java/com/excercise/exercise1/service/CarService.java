package com.excercise.exercise1.service;

import com.excercise.exercise1.domain.car.Car;
import com.excercise.exercise1.domain.car.CarRepository;
import com.excercise.exercise1.domain.user.User;
import com.excercise.exercise1.domain.user.UserRepository;
import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    final private CarRepository carRepository;
    final private UserService userService;

    // 차량 넘버 뒷자리 4자리 차량 조회
    @Transactional(readOnly = true)
    public List<CarDto> findCarList(HttpSession session, String target){
        // user 검색
        UserDto userDto = (UserDto) session.getAttribute("user");
        User user = userService.findByUsername(userDto.getUsername());
        List<Car> list = null;

        // target이 없을 경우
        if(target.equals("")){
            list = carRepository.findByUser(user);
        }
        // target이 있을 경우
        if(!target.isEmpty()) {
            list = carRepository.findByLastFourNumbers(user.getId(), target);
        }

        return list.stream().map(CarDto::new).collect(Collectors.toList());
    }
}
