package com.gaaji.town.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

    private String timeStamp;
    private HttpStatus httpStatus;
    private String errorCode;
    private String errorName;
    private String errorMessage;
    private String path;

    public static ErrorResponse createErrorResponse(ErrorCode errorCode, String path) {
        return new ErrorResponse(LocalDateTime.now().toString(),errorCode.getHttpStatus(),errorCode.getErrorCode()
                , errorCode.getErrorName(), errorCode.getErrorMessage(),path);
    }

    @Override
    public String toString() {
        return "{" +
                "timeStamp=" + timeStamp +
                ", httpStatus=" + httpStatus +
                ", errorCode='" + errorCode + '\'' +
                ", errorName='" + errorName + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
