package com.gaaji.town.repository;

import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.AuthTown;
import com.gaaji.town.domain.AuthTownId;
import com.gaaji.town.domain.TownId;
import java.util.List;

public interface AuthTownRepository {

    AuthTown save(AuthId authId, TownId townId);

    AuthTown findByAuthTownId(AuthTownId authTownId);


    boolean findAuthTown(AuthTownId authTownId);

    List<TownId> findByAuthId(AuthId of);

    long countAuthTownByAuthId(AuthId authId);

    void delete(AuthId authId, TownId townId);

    void updateTownByTownId(AuthId authId, TownId from, TownId to);

	long countAuthTownByAuthIdAndTownId(AuthId of, TownId of2);
}
