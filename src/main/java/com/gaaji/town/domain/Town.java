package com.gaaji.town.domain;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Town {

    @EmbeddedId
    private TownId townId;

    @Embedded
    private Address address;


    public static Town of(TownId townId, Address address){
        return new Town(townId, address);
    }


}
