package com.excercise.exercise1.domain.user;

import com.excercise.exercise1.domain.car.Car;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();


    public User(String username) {
        this.username = username;
    }

    public void addCar(Car car) {
        this.cars.add(car);
        if(car.getUser() != this){
            car.setUser(this);
        }
    }
}
