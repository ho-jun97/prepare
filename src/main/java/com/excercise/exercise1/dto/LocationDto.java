package com.excercise.exercise1.dto;

import com.excercise.exercise1.domain.location.Location;
import lombok.*;

@Data
@NoArgsConstructor
public class LocationDto {
    private double lat;
    private double lng;

    @Builder
    public LocationDto(Location location){
        this.lat = location.getLat();
        this.lng = location.getLng();
    }
}
