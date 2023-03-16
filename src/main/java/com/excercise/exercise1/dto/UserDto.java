package com.excercise.exercise1.dto;

import lombok.*;

@NoArgsConstructor
@Data
public class UserDto {

    private Long id;
    private String username;


    @Builder
    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    static public UserDto of(Long id, String username){
        return UserDto.builder()
                .id(id)
                .username(username)
                .build();
    }

}
