package com.gaaji.town.exception;

public class MinTownNumException extends AbstractApiException {
	
	public MinTownNumException() {
		super(TownErrorCode.Min_Town_Num);
	}
}
