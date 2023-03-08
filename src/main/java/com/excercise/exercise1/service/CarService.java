package com.excercise.exercise1.service;

import com.excercise.exercise1.domain.car.Car;
import com.excercise.exercise1.domain.car.CarRepository;
import com.excercise.exercise1.domain.user.UserRepository;
import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    final private CarRepository carRepository;
    final private UserRepository userRepository;

    // 자신 보유 차량 넘버 뒷자리 4자리 차량 조회
    @Transactional(readOnly = true)
    public List<CarDto> findCarList(UserDto userDto, String target){
        List<Car> carList = null;

        if(StringUtils.hasText(target)){
            carList = carRepository.findByLastFourNumbers(userDto.getId(), target);
        }else{
            carList = carRepository.findByUserId(userDto.getId());
        }

        return carList.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
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
}
