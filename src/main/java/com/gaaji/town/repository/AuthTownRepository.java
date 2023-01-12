package com.gaaji.town.repository;

import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.AuthTown;
import com.gaaji.town.domain.TownId;

public interface AuthTownRepository {

    AuthTown save(AuthId authId, TownId townId);


}
