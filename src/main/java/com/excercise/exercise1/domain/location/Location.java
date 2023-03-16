package com.excercise.exercise1.domain.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public static Location createLocation(double lat, double lng) {
        return Location.builder()
                .lat(lat)
                .lng(lng)
                .build();
    }

    public void update(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
