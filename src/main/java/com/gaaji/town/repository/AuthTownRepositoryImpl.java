package com.gaaji.town.repository;

import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.AuthTown;
import com.gaaji.town.domain.TownId;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AuthTownRepositoryImpl implements AuthTownRepository{

    private final EntityManager em;

    @Override
    public AuthTown save(AuthId authId, TownId townId) {

        AuthTown authTown = AuthTown.of(authId, townId);
        em.persist(authTown);

        return authTown;
    }
}
