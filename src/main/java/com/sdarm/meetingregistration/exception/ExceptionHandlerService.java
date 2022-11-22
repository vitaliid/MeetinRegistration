package com.sdarm.meetingregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface ExceptionHandlerService {

    ResponseEntity<Object> unknownExceptionHandler(Exception exception, HttpServletRequest request);

    ResponseEntity<Object> unknownExceptionHandler(Exception exception, HttpServletRequest request,
                                                   HttpStatus httpStatus);
}
