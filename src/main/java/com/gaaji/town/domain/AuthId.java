package com.gaaji.town.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class AuthId implements Serializable {

    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthId authId1 = (AuthId) o;
        return Objects.equals(id, authId1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static AuthId of (String authId) {
        return new AuthId(authId);
    }

}
