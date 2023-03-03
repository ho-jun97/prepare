package com.excercise.exercise1.service;

import com.excercise.exercise1.domain.user.User;
import com.excercise.exercise1.domain.user.UserRepository;
import com.excercise.exercise1.dto.LoginDto;
import com.excercise.exercise1.dto.UserDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepository userRepository;

    public User findByUsername(String username){

        User user = userRepository.findByUsername(username).orElse(null);

//        User user = userRepository.findByUsername(userDto.getUsername())
//                .orElseThrow(() -> new Exception("User를 찾지 못하였습니다."));

        return user;
    }

    public boolean checkLogin(LoginDto loginDto){
        User user = findByUsername(loginDto.getUsername());

        if(user == null) return false;
        return user.getPassword().equals(loginDto.getPassword());
    }
}