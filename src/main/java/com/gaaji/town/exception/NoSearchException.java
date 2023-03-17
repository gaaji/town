package com.gaaji.town.exception;

public class NoSearchException extends AbstractApiException {

	public NoSearchException() {
		super(TownErrorCode.No_Search);
	}

}
