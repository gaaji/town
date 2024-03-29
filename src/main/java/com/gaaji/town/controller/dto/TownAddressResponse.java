package com.gaaji.town.controller.dto;


import javax.persistence.Access;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE) @NoArgsConstructor
public class TownAddressResponse {
    private String address;

    public static TownAddressResponse of(String address){
        return new TownAddressResponse(address);
    }
}
