package com.gaaji.town.controller;

import com.gaaji.town.applicationservice.TownRetrieveService;
import com.gaaji.town.controller.dto.TownRetrieveResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/town")
@RestController
public class TownRetrieveController {

    private final TownRetrieveService townRetrieveService;

    @GetMapping
    public ResponseEntity<List<TownRetrieveResponse>> retrieveMyTown(
            @RequestHeader("authId") String authId){
        List<TownRetrieveResponse> towns = townRetrieveService.retrieveMyTown(authId);
        return ResponseEntity.ok(towns);
    }
}
