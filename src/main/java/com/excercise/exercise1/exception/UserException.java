package com.excercise.exercise1.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserException extends RuntimeException{
    private final UserExceptionResult userExceptionResult;
}
