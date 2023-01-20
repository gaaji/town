package com.gaaji.town.applicationservice.impl;

import com.gaaji.town.applicationservice.TownRetrieveService;
import com.gaaji.town.controller.dto.TownAddressResponse;
import com.gaaji.town.controller.dto.TownRetrieveResponse;
import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.TownId;
import com.gaaji.town.repository.AuthTownRepository;
import com.gaaji.town.repository.TownRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TownRetrieveServiceImpl implements
        TownRetrieveService {

    private final TownRepository townRepository;
    private final AuthTownRepository authTownRepository;

    @Override
    public List<TownRetrieveResponse> retrieveMyTown(String authId) {
        List<TownId> townIds = authTownRepository.findByAuthId(AuthId.of(authId));

        List<TownRetrieveResponse> townRetrieveResponse = new ArrayList<>();
        for (TownId townId : townIds) {
            townRetrieveResponse.add(new TownRetrieveResponse(townRepository.findByTownId(townId)));
        }

        return townRetrieveResponse;
    }

    @Override
    public TownAddressResponse retrieveTownAddress(String townId) {
        return TownAddressResponse.of(townRepository.findByTownId(TownId.of(townId)).getAddress2());
    }
}
