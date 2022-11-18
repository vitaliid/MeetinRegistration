package com.sdarm.meetingregistration.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private int status;

    private String error;

    private String message;

    private String path;

    private int errorCode;

    private String exceptionMessage;

    private String rootExceptionMessage;

    private String trace;

}
