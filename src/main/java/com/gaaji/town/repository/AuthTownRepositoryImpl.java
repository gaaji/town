package com.gaaji.town.repository;

import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.AuthTown;
import com.gaaji.town.domain.AuthTownId;
import com.gaaji.town.domain.TownId;
import java.util.NoSuchElementException;
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

    @Override
    public AuthTown findByAuthTownId(AuthTownId authTownId) {

        try {
            return em.createQuery("select at from AuthTown at "
                    + " where at.authTownId =:authTownId ", AuthTown.class)
                    .setParameter("authTownId", authTownId)
                    .getSingleResult();
        } catch (NoSuchElementException e) {
            e.printStackTrace(); //
            throw new RuntimeException(); // TODO 조회 실패 custom exception 생성
        }
    }

    @Override
    public boolean findAuthTown(AuthTownId authTownId) {
        try {
            return em.createQuery("select at.authentication from AuthTown at "
                            + " where at.authTownId =:authTownId ", Boolean.class)
                    .setParameter("authTownId", authTownId).getSingleResult();
        } catch (NoSuchElementException e) {
            e.printStackTrace(); //
            throw new RuntimeException(); // 조회 실패 exception 발생
        }
    }
}
