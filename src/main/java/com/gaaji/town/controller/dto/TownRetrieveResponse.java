package com.gaaji.town.controller.dto;

import com.gaaji.town.domain.Town;
import lombok.Data;

@Data
public class TownRetrieveResponse {

    private String id;
    private String address1;
    private String address2;

    public TownRetrieveResponse(Town town) {
        this.id = town.getTownId();
        this.address1 = town.getAddress1();
        this.address2 = town.getAddress2();
    }
}
