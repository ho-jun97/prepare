package com.excercise.exercise1.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CarException extends RuntimeException{
    private final CarExceptionResult carExceptionResult;
}
