package com.gaaji.town.controller;

import com.gaaji.town.applicationservice.TownTokenCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/town")
@RequiredArgsConstructor
@RestController
public class TownTownCreateController {

    private final TownTokenCreateService townTokenCreateService;

    @PostMapping("/token")
    public ResponseEntity<Void> checkAuthentication(@RequestHeader("authId") String authId){
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-TOWN-TOKEN", townTokenCreateService
                        .createAuthenticationToken(authId)).build();
    }

}
