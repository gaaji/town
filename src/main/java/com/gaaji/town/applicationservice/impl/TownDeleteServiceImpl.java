package com.gaaji.town.applicationservice.impl;

import com.gaaji.town.applicationservice.TownDeleteService;
import com.gaaji.town.domain.AuthId;
import com.gaaji.town.domain.TownId;
import com.gaaji.town.repository.AuthTownRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TownDeleteServiceImpl implements TownDeleteService {

    private final AuthTownRepository authTownRepository;

    @Override
    public void deleteTown(String authId, String townId) {

        // 동네_유저 개수 확인
        long numTowns = authTownRepository.countAuthTownByAuthId(AuthId.of(authId));
        if(numTowns == 1)
            throw new RuntimeException(); // 1개면 삭제할 수 없습니다. 동네를 변경해주세요.
        // 1개뿐이면 exception 반환 아니면 삭제
        authTownRepository.delete(AuthId.of(authId), TownId.of(townId));
    }
}
