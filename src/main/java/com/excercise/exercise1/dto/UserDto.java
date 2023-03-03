package com.excercise.exercise1.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class UserDto {

    private Long id;
    private String username;


    //
    static public UserDto of(Long id, String username){
        return UserDto.builder()
                .id(id)
                .username(username)
                .build();
    }

}
