package com.gaaji.town.repository;

import com.gaaji.town.domain.Address;
import com.gaaji.town.domain.Town;
import com.gaaji.town.domain.TownId;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTownRepository extends JpaRepository<Town, TownId> {

    Optional<Town> findTownByAddress(Address address);

}
