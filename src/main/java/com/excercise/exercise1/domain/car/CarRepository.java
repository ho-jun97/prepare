package com.excercise.exercise1.domain.car;

import com.excercise.exercise1.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c where c.user.id = :userId and right(c.number,4)=:number")
    List<Car> findByLastFourNumbers(@Param("userId") Long userId, @Param("number") String number);
}
