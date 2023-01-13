package com.gaaji.town.exception;

public class NoSerchException extends AbstractApiException {

	public NoSerchException() {
		super(TownErrorCode.No_Serch);
	}

}
