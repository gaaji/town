package com.gaaji.town.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TownExceptionHandler {

	 @ExceptionHandler(AbstractApiException.class)
	    public ResponseEntity<ErrorResponse> handleGlobalException(AbstractApiException ex, HttpServletRequest request) {
	        return ResponseEntity.status(ex.getHttpStatus())
	                .body(ErrorResponse.createErrorResponse(ex, request.getRequestURI()));
	    }
	
}
