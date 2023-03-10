package com.excercise.exercise1.domain.location;

import com.excercise.exercise1.domain.car.Car;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 위도
    private double lat;
    // 경도
    private double lng;

    @Builder
    public Location(Long id, double lat, double lng) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
    }

    public static Location createLocation(double lat, double lng) {
        return Location.builder()
                .lat(lat)
                .lng(lng)
                .build();
    }
}
