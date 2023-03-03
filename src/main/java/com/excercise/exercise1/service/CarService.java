package com.excercise.exercise1.service;

import com.excercise.exercise1.domain.car.Car;
import com.excercise.exercise1.domain.car.CarRepository;
import com.excercise.exercise1.domain.user.User;
import com.excercise.exercise1.domain.user.UserRepository;
import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    final private CarRepository carRepository;
    final private UserService userService;

    public List<CarDto> findCarList(UserDto userDto, String target){

        User user = userService.findByUsername(userDto.getUsername());
        List<Car> list = carRepository.findByLastFourNumbers(user.getId(),target);

        return list.stream().map(CarDto::new).collect(Collectors.toList());
    }
}
