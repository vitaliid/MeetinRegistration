package com.sdarm.meetingregistration.exception;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface ExceptionHandlerService {

    ResponseEntity<Object> unknownExceptionHandler(Exception exception, HttpServletRequest request);
}
