package com.sdarm.meetingregistration.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RequiredArgsConstructor
@Service
public class ExceptionHandlerServiceImpl implements ExceptionHandlerService {

    private static final String CORE_PACKAGE_NAME = "com.sdarm.meetingregistration";

    @Value("${application.returnStackTraceOnError:false}")
    private boolean returnStackTrace;

    private final MessageSource messageSource;


    @Override
    public ResponseEntity<Object> unknownExceptionHandler(Exception exception, HttpServletRequest request) {
        return unknownExceptionHandler(exception, request, INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> unknownExceptionHandler(Exception exception, HttpServletRequest request,
                                                           HttpStatus httpStatus) {
        String trace = returnStackTrace ? Stream.of(exception.getStackTrace())
                .filter(e -> e.getClassName().startsWith(CORE_PACKAGE_NAME))
                .map(Object::toString)
                .collect(Collectors.joining(", "))
                : null;

        ErrorResponse response = ErrorResponse.builder()
                .status(httpStatus.value())
                .error(exception.getClass().getSimpleName())
                .errorCode(ErrorCode.INTERNAL_ERROR)
                .path(request.getServletPath())
                .message("Something wrong with you, Pasha")
                .exceptionMessage(exception.getMessage())
                .rootExceptionMessage(ExceptionUtils.getRootCauseMessage(exception))
                .trace(trace)
                .build();

        return processError(exception, response);
    }

    private ResponseEntity<Object> processError(Exception ex, ErrorResponse response) {
        log.error("Handled: " + ex.getClass().getSimpleName());

        String message;
        // if (ex instanceof HttpException exception) {
        //      message = getMessage(ex.getMessage(), Locale.ENGLISH, exception.getParams());
        //   } else {
        message = ex.getMessage();
        //   }

        log.error("Cause: " + message, ex);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    private String getMessage(String messageCode, String... params) {
        return getMessage(messageCode, Locale.ENGLISH, params);
    }

    private String getMessage(String messageCode, Locale locale, String... params) {
        return messageSource.getMessage(messageCode, params, messageCode, locale);
    }
}
