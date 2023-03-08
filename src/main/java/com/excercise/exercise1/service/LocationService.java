package com.excercise.exercise1.service;

import com.excercise.exercise1.domain.location.LocationRepository;
import com.excercise.exercise1.dto.LocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LocationService {
    final private LocationRepository locationRepository;

    @Transactional(readOnly = true)
    public List<LocationDto> findAll(){
        return locationRepository.findAll()
                .stream()
                .map(LocationDto::new)
                .collect(Collectors.toList());
    }
}
