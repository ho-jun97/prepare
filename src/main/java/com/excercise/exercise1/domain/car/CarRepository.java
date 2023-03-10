package com.excercise.exercise1.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c join fetch c.location where c.user.id = :userId and c.number like %:number")
    List<Car> findByLastFourNumbers(@Param("userId") Long userId, @Param("number") String number);

    @Query("select c from Car c join fetch c.location where c.user.id = :userId")
    List<Car> findByUserId(@Param("userId") Long userId);

}
