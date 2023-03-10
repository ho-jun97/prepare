package com.excercise.exercise1.dto;

import com.excercise.exercise1.domain.car.Car;
import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CarDto {
    private Long id;

    private String number;
    private String username;

    private String address;

    private double lat;

    private double lng;


    @Builder
    public CarDto(Car car){
        this.id = car.getId();
        this.number = car.getNumber();
        this.username = car.getUser().getUsername();
        this.address = car.getAddress();
        this.lat = car.getLocation().getLat();
        this.lng = car.getLocation().getLng();
    }

    public static CarDto of(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .number(car.getNumber())
                .username(car.getUser().getUsername())
                .address(car.getAddress())
                .lat(car.getLocation().getLat())
                .lng(car.getLocation().getLng())
                .build();
    }
}


