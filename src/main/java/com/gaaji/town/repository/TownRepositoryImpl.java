package com.gaaji.town.repository;

import com.gaaji.town.domain.Address;
import com.gaaji.town.domain.Town;
import com.gaaji.town.domain.TownId;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TownRepositoryImpl implements TownRepository{

    private final JpaTownRepository jpaTownRepository;

    @Override
    public Town save(Address address) {
        return jpaTownRepository.save(Town.of(TownId.of(this.nextId()),address));
    }

    @Override
    public Optional<Town> findByAddress(Address address) {
        return jpaTownRepository.findTownByAddress(address);
    }
}
