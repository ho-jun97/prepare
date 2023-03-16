package com.excercise.exercise1.domain.car;

import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.CarSearchCondition;

import java.util.List;

public interface CarRepositoryCustom {

    List<CarDto> search(CarSearchCondition condition);
}
