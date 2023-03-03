package com.excercise.exercise1.domain.car;

import com.excercise.exercise1.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



}
