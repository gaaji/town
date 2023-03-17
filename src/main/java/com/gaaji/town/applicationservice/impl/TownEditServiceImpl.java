package com.gaaji.town.applicationservice.impl;

import com.gaaji.town.applicationservice.TownEditService;
import com.gaaji.town.domain.Address;
import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.Town;
import com.gaaji.town.domain.TownId;
import com.gaaji.town.repository.AuthTownRepository;
import com.gaaji.town.repository.TownRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TownEditServiceImpl implements TownEditService {

    private final AuthTownRepository authTownRepository;
    private final TownRepository townRepository;

    @Override
    public void editTown(String authId, String originalTownId, String address1, String address2) {

        Town town = townRepository.findByAddress(Address.of(address1,address2))
                .orElseGet(() -> townRepository.save(Address.of(address1,address2)));

        authTownRepository.updateTownByTownId(AuthId.of(authId), TownId.of(originalTownId),
                TownId.of(town.getTownId()));
    }
}
