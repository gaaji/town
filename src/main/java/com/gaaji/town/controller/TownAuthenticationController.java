package com.gaaji.town.controller;

import com.gaaji.town.applicationservice.TownAuthenticationService;
import com.gaaji.town.controller.dto.CheckAuthenticateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/town")
@RequiredArgsConstructor
@RestController
public class TownAuthenticationController {

    private final TownAuthenticationService townAuthenticationService;

    @PatchMapping("/authentication/{townId}")
    public ResponseEntity<Void> authenticateTown(@PathVariable("townId") String townId ,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authId){
            townAuthenticationService.authenticateTown(townId, authId);
            return ResponseEntity.ok().build();
    }

}
