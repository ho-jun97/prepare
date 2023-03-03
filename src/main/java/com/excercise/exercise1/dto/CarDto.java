package com.excercise.exercise1.dto;

import com.excercise.exercise1.domain.car.Car;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CarDto {

    private String number;
    private UserDto userDto;

    @Builder
    public CarDto(Car car){
        this.number = car.getNumber();
        this.userDto = userDto.builder()
                .id(car.getUser().getId())
                .username(car.getUser().getUsername())
                .build();
    }

}
