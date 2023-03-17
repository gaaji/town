package com.gaaji.town.repository;

import com.gaaji.town.controller.dto.TownToken;
import com.gaaji.town.domain.AuthId;
import java.util.List;

public interface TownCreateRepository {

    List<TownToken> findTownTokens(AuthId authId);

}
