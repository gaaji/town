package com.gaaji.town.controller;


import com.gaaji.town.applicationservice.TownDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/town")
@RequiredArgsConstructor
@RestController
public class TownDeleteController {

    private final TownDeleteService townDeleteService;



    @DeleteMapping("/{townId}")
    public ResponseEntity<Void> deleteTown(@RequestHeader String authId, @PathVariable("townId") String townId){

        townDeleteService.deleteTown(authId, townId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
