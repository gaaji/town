package com.gaaji.town.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class TownToken {

    private String townId;
    private String address;
    private boolean isAuthenticated;


    public static TownToken of(String townId, String address, boolean isAuthenticated){
        return new TownToken(townId, address, isAuthenticated);
    }

}
