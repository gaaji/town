package com.gaaji.town.exception;

public class MaxTownNumException extends AbstractApiException {

	public MaxTownNumException() {
		super(TownErrorCode.Max_Town_Num);
	}

}
