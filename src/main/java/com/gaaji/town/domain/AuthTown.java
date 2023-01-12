package com.gaaji.town.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class AuthTown {

    @EmbeddedId
    private AuthId authId;

    @EmbeddedId
    private TownId townId;
    private boolean authentication;

    public void authenticate(){
        this.authentication = true;
    }

    public static AuthTown of(AuthId authId, TownId townId){
        return new AuthTown(authId, townId,false);
    }
}
