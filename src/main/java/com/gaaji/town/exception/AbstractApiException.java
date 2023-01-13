package com.gaaji.town.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public abstract class AbstractApiException extends RuntimeException implements ErrorCode {

	private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorName;
    private final String errorMessage;

    protected AbstractApiException (ErrorCode errorCode) {

        httpStatus = errorCode.getHttpStatus();
        this.errorCode = errorCode.getErrorCode();
        errorName = errorCode.getErrorName();
        errorMessage = errorCode.getErrorMessage();
    }

}