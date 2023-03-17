package com.gaaji.town.repository;

import com.gaaji.town.controller.dto.TownRetrieveResponse;
import com.gaaji.town.domain.Address;
import com.gaaji.town.domain.Town;
import com.gaaji.town.domain.TownId;
import java.util.Optional;
import java.util.UUID;

public interface TownRepository {

    Town save(Address address);

    Optional<Town> findByAddress(Address address);

    default String nextId(){
        return UUID.randomUUID().toString();
    }

    Town findByTownId(TownId townId);
}
