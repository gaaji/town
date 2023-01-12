package com.gaaji.town.applicationservice;


import com.gaaji.town.domain.Address;
import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.Town;
import com.gaaji.town.domain.TownId;
import com.gaaji.town.repository.AuthTownRepository;
import com.gaaji.town.repository.TownRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class TownRegisterServiceImpl implements TownRegisterService {

    private final TownRepository townRepository;
    private final AuthTownRepository authTownRepository;


    @Override
    public void registerTown(String authId, String address1, String address2) {
        // 있는지 검색
        Town town = townRepository.findByAddress(Address.of(address1,address2))
                .orElseGet(() -> townRepository.save(Address.of(address1,address2)));
        // AuthTown 생성
        authTownRepository.save(AuthId.of(authId), TownId.of(town.getTownId()));

    }
}
