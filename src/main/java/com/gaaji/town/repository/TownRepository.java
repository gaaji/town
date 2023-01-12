package com.gaaji.town.repository;

import com.gaaji.town.domain.Address;
import com.gaaji.town.domain.Town;
import java.util.Optional;
import java.util.UUID;

public interface TownRepository {

    Town save(Address address);

    Optional<Town> findByAddress(Address address);

    default String nextId(){
        return UUID.randomUUID().toString();
    }
}
