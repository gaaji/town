package com.gaaji.town.repository;

import com.gaaji.town.controller.dto.TownToken;
import com.gaaji.town.domain.AuthId;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TownCreateRepositoryImpl implements TownCreateRepository{

    private final EntityManager em;

    @Override
    public List<TownToken> findTownTokens(AuthId authId) {

        return em.createQuery("select new com.gaaji.town.controller.dto.TownToken(at.authTownId.townId.id,at.authentication) from AuthTown at "
                + "where at.authTownId.authId =:authId "
                        + "order by at.authentication desc ", TownToken.class)
                .setParameter("authId", authId)
                .getResultList();
    }
}
