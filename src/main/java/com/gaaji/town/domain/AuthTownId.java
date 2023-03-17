package com.gaaji.town.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class AuthTownId implements Serializable {

    @Embedded
    private AuthId authId;

    @Embedded
    private TownId townId;

    public static AuthTownId of(AuthId authId, TownId townId){
        return new AuthTownId(authId,townId);
    }

}
