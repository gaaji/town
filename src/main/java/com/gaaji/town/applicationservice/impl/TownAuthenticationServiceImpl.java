package com.gaaji.town.applicationservice.impl;

import com.gaaji.town.applicationservice.TownAuthenticationService;
import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.AuthTown;
import com.gaaji.town.domain.AuthTownId;
import com.gaaji.town.domain.TownId;
import com.gaaji.town.repository.AuthTownRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TownAuthenticationServiceImpl implements
        TownAuthenticationService {

    private final AuthTownRepository authTownRepository;

    @Override
    public void authenticateTown(String townId, String authId) {
        AuthTown authTown = authTownRepository.findByAuthTownId(AuthTownId.of(AuthId.of(authId),
                TownId.of(townId)));
        authTown.authenticate();
    }

    @Override
    public boolean checkAuthentication(String townId, String authId) {
        return authTownRepository.findAuthTown(AuthTownId.of(AuthId.of(authId),TownId.of(townId)));
    }
}
