package com.gaaji.town.applicationservice.impl;


import com.gaaji.town.applicationservice.TownRegisterService;
import com.gaaji.town.domain.Address;
import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.Town;
import com.gaaji.town.domain.TownId;
import com.gaaji.town.exception.MaxTownNumException;
import com.gaaji.town.exception.OverlapTownException;
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
        
        long numTowns = authTownRepository.countAuthTownByAuthId(AuthId.of(authId));
        if(numTowns == 2)
            throw new MaxTownNumException();
        // TODO 2개 초과는 저장 불가능.
    	
        numTowns = authTownRepository.countAuthTownByAuthIdAndTownId(AuthId.of(authId), TownId.of(town.getTownId()));
        if(numTowns > 0)
        	throw new OverlapTownException();
        // TODO 중복되는 동네 추가시 예외
        authTownRepository.save(AuthId.of(authId), TownId.of(town.getTownId()));
    }
}
