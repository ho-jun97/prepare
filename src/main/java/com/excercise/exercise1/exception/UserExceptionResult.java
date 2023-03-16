package com.excercise.exercise1.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum UserExceptionResult {

    USER_NOT_FOUND(HttpStatus.UNAUTHORIZED, "사용자를 찾지 못하였습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
