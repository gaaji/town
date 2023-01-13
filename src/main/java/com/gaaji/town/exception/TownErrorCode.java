package com.gaaji.town.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TownErrorCode implements ErrorCode {

	Max_Town_Num(HttpStatus.UNAUTHORIZED,"A-0001", "등록된 동네의 개수가 최대치입니다."),
	Min_Town_Num(HttpStatus.UNAUTHORIZED,"A-0002", "최소 1개의 동네를 가지고 있어야 합니다."),
	Overlap_Town(HttpStatus.UNAUTHORIZED,"A-0003", "이미 등록된 동네를 입력했습니다."),
	No_Serch(HttpStatus.UNAUTHORIZED,"A-0004", "검색된 유저 정보가 존재하지 않습니다."),
    ;
	
	private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    public String getErrorName() {
        return this.name();
    }
}
