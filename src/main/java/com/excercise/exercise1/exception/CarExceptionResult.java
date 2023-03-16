package com.excercise.exercise1.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum CarExceptionResult {

    CAR_NOT_FOUND(HttpStatus.UNAUTHORIZED, "차량을 찾지 못하였습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
