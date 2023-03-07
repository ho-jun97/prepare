package com.excercise.exercise1.domain.location;

import com.excercise.exercise1.domain.car.Car;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 위도
    private String lat;
    // 경도
    private String lng;
}
