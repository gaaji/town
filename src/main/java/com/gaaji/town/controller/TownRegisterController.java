package com.gaaji.town.controller;

import com.gaaji.town.applicationservice.TownRegisterService;
import com.gaaji.town.controller.dto.TownRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/town")
@RequiredArgsConstructor
@RestController
public class TownRegisterController {

    private final TownRegisterService townRegisterService;

    @PostMapping
    public ResponseEntity<Void> registerTown(@RequestHeader(HttpHeaders.AUTHORIZATION) String authId, @RequestBody TownRegisterRequest dto){
        townRegisterService.registerTown(authId,dto.getAddress1(),dto.getAddress2());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
