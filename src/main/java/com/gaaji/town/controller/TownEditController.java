package com.gaaji.town.controller;

import com.gaaji.town.applicationservice.TownEditService;
import com.gaaji.town.controller.dto.TownEditRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/town")
@RequiredArgsConstructor
@RestController
public class TownEditController {

    private final TownEditService townEditService;

    @PatchMapping
    public ResponseEntity<Void> editTown(@RequestBody TownEditRequest dto,
            @RequestHeader("authId") String authId){
        townEditService.editTown(authId, dto.getOriginalTownId(), dto.getAddress1(), dto.getAddress2());
        return ResponseEntity.ok().build();
    }
}
