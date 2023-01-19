package com.gaaji.town.controller.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TownToken implements Serializable {

    private String townId;
    private String address;
    private boolean isAuthenticated;


    public static TownToken of(String townId, String address, boolean isAuthenticated){
        return new TownToken(townId, address, isAuthenticated);
    }

}
