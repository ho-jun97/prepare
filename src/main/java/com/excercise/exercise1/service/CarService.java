package com.excercise.exercise1.service;

import com.excercise.exercise1.domain.car.Car;
import com.excercise.exercise1.domain.car.CarRepository;
import com.excercise.exercise1.domain.location.Location;
import com.excercise.exercise1.domain.user.User;
import com.excercise.exercise1.domain.user.UserRepository;
import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.CarSearchCondition;
import com.excercise.exercise1.dto.UserDto;
import com.excercise.exercise1.exception.CarException;
import com.excercise.exercise1.exception.CarExceptionResult;
import com.excercise.exercise1.exception.UserException;
import com.excercise.exercise1.exception.UserExceptionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    final private CarRepository carRepository;
    final private UserRepository userRepository;

    // 자신 보유 차량 넘버 뒷자리 4자리 차량 조회
    @Transactional(readOnly = true)
    public List<CarDto> findCarList(UserDto userDto, CarSearchCondition condition){
        condition.setUsername(userDto.getUsername());
        return carRepository.search(condition);
    }

    // 차량 한대 조회
    @Transactional(readOnly = true)
    public Car findById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("차량을 찾지 못하였습니다."));
        return car;
    }

    // 모든 차량 조회
    @Transactional(readOnly = true)
    public List<CarDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public void addCar(UserDto userDto, CarDto carDto){
        // 1. 유저 조회
        User user = userRepository.findById(userDto.getId()).orElseThrow(
                () -> new UserException(UserExceptionResult.USER_NOT_FOUND));
        // 2. Location 객체 만들기
        Location location = Location.createLocation(carDto.getLat(), carDto.getLng());
        // 3. 새로운 차 객체 만들기
        Car car = Car.createCar(carDto.getNumber(), carDto.getAddress(), location);
        // 5. 유저와 차 매핑
        user.addCar(car);
        // 6. 저장
        carRepository.save(car);
    }

    @Transactional
    public void updateCar(Long carId, CarDto carDto) {
        Car car = carRepository.findById(carId).orElseThrow(
                () -> new CarException(CarExceptionResult.CAR_NOT_FOUND));
        car.update(carDto);
    }
}
