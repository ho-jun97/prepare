package com.excercise.exercise1.controller;

import com.excercise.exercise1.dto.PositionDto;
import com.excercise.exercise1.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class LocationController {

    final private LocationService locationService;

    /**
     * 모든 차량의 리스트 반환하는 메소드
     * (kakao map 에 나타내기 위한 메소드)
     * @return json 형태로 내보내기 위해 ResponseEntity 로 리스트를 감싼 형태
     */
    @GetMapping("findAllLocation")
    public ResponseEntity<PositionDto> findAllLocation(){

        return ResponseEntity.ok(new PositionDto(locationService.findAll()));
    }
}
