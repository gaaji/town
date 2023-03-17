package com.gaaji.town.controller.dto;

import lombok.Data;

@Data
public class CheckAuthenticateResponse {

    private boolean authentication;

    public CheckAuthenticateResponse(boolean authentication) {
        this.authentication = authentication;
    }
}
