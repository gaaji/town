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
public class TownId implements Serializable {

    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TownId townId1 = (TownId) o;
        return Objects.equals(id, townId1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public static TownId of (String id) {
        return new TownId(id);
    }

}
