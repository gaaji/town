package com.gaaji.town.domain;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class Address {

    private String address1;
    private String address2;

    public static Address of(String address1, String address2) {
        return new Address(address1,address2);
    }
}
