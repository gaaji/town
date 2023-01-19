package com.gaaji.town.applicationservice.impl;

import com.gaaji.town.applicationservice.TownTokenCreateService;
import com.gaaji.town.controller.dto.TownToken;
import com.gaaji.town.domain.AuthId;
import com.gaaji.town.jwt.JwtProvider;
import com.gaaji.town.repository.TownCreateRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TownTokenCreateServiceImpl implements TownTokenCreateService {

    private final JwtProvider jwtProvider;
    private final TownCreateRepository townCreateRepository;

    @Override
    public String createAuthenticationToken(String authId) {
        return createTokenByFirstTown(findRegisteredTown(authId));
    }

    private List<TownToken> findRegisteredTown(String authId) {
        return townCreateRepository.findTownTokens(AuthId.of(authId));
    }

    private String createTokenByFirstTown(List<TownToken> tokens) {
        return jwtProvider.createTownToken(tokens.get(0));
    }
}
