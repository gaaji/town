package com.gaaji.town.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Access(AccessType.FIELD)
@Embeddable
public class Address {

    private String address1;
    private String address2;

    protected String getAddress1() {
        return address1;
    }

    protected String getAddress2() {
        return address2;
    }

    public static Address of(String address1, String address2) {
        return new Address(address1,address2);
    }
}
