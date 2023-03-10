package com.excercise.exercise1.domain.car;

import com.excercise.exercise1.domain.location.Location;
import com.excercise.exercise1.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String address;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;


    private void addUser(User user){
        this.user = user;
    }

    @Builder
    public Car(Long id, String number, User user, String address, Location location) {
        this.id = id;
        this.number = number;
        this.user = user;
        this.address = address;
        this.location = location;
    }

    static public Car createCar(String number, String address, Location location){
        return Car.builder()
                .number(number)
                .address(address)
                .location(location)
                .build();
    }

    public void setUser(User user) {
        if(this.user != null){
            this.user.getCars().remove(this);
        }
        this.user = user;
        if(!this.user.getCars().contains(this)){
            this.user.addCar(this);
        }
    }
}
