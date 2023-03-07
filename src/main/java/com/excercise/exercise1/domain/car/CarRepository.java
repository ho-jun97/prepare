package com.excercise.exercise1.domain.car;

import com.excercise.exercise1.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c where c.user.id = :userId and c.number like %:number")
    List<Car> findByLastFourNumbers(@Param("userId") Long userId, @Param("number") String number);
    List<Car> findByUser(User user);

    Optional<Car> findById(Long id);
}
