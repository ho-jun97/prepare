package com.excercise.exercise1.dto;

import com.excercise.exercise1.domain.car.Car;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CarDto {
    private Long id;

    private String number;
    private UserDto user;

    @Builder
    public CarDto(Car car){
        this.id = car.getId();
        this.number = car.getNumber();
        this.user = UserDto.builder()
                .id(car.getUser().getId())
                .username(car.getUser().getUsername())
                .build();
    }

}
