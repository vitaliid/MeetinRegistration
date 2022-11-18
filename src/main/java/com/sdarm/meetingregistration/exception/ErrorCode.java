package com.sdarm.meetingregistration.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCode {

    public static final int INTERNAL_ERROR = 10000;//show red error on FE

    public static final int BAD_REQUEST = 10001;//show warning on FE

    public static final int FORBIDDEN = 10002;

    public static final int VALIDATION_ERROR = 10003;//if this code used FE should show error message from be response

}
